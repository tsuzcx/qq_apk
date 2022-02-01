package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CharsetDetector
{
  private static final List<CharsetDetector.CSRecognizerInfo> ALL_CS_RECOGNIZERS;
  private static final int kBufSize = 8000;
  short[] fByteStats = new short[256];
  boolean fC1Bytes = false;
  String fDeclaredEncoding;
  private boolean[] fEnabledRecognizers;
  byte[] fInputBytes = new byte[8000];
  int fInputLen;
  InputStream fInputStream;
  byte[] fRawInput;
  int fRawLength;
  private boolean fStripTags = false;
  
  static
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_UTF8(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_Unicode.CharsetRecog_UTF_16_BE(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_Unicode.CharsetRecog_UTF_16_LE(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_Unicode.CharsetRecog_UTF_32_BE(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_Unicode.CharsetRecog_UTF_32_LE(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_mbcs.CharsetRecog_sjis(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_2022.CharsetRecog_2022JP(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_2022.CharsetRecog_2022CN(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_2022.CharsetRecog_2022KR(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_mbcs.CharsetRecog_gb_18030(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_mbcs.CharsetRecog_euc.CharsetRecog_euc_jp(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_mbcs.CharsetRecog_euc.CharsetRecog_euc_kr(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_mbcs.CharsetRecog_big5(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_8859_1(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_8859_2(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_8859_5_ru(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_8859_6_ar(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_8859_7_el(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_8859_8_I_he(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_8859_8_he(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_windows_1251(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_windows_1256(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_KOI8_R(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_8859_9_tr(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_IBM424_he_rtl(), false));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_IBM424_he_ltr(), false));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_IBM420_ar_rtl(), false));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_IBM420_ar_ltr(), false));
    ALL_CS_RECOGNIZERS = Collections.unmodifiableList(localArrayList);
  }
  
  private void MungeInput()
  {
    int k;
    if (this.fStripTags)
    {
      int i2 = 0;
      int i3 = 0;
      k = 0;
      j = 0;
      int m = 0;
      while ((i2 < this.fRawLength) && (i3 < this.fInputBytes.length))
      {
        int i = this.fRawInput[i2];
        int i4 = k;
        int i1 = j;
        int n = m;
        if (i == 60)
        {
          i1 = j;
          if (m != 0) {
            i1 = j + 1;
          }
          i4 = k + 1;
          n = 1;
        }
        j = i3;
        if (n == 0)
        {
          this.fInputBytes[i3] = i;
          j = i3 + 1;
        }
        m = n;
        if (i == 62) {
          m = 0;
        }
        i2 += 1;
        i3 = j;
        k = i4;
        j = i1;
      }
      this.fInputLen = i3;
    }
    else
    {
      k = 0;
      j = 0;
    }
    if ((k < 5) || (k / 5 < j) || ((this.fInputLen < 100) && (this.fRawLength > 600)))
    {
      k = this.fRawLength;
      j = k;
      if (k > 8000) {
        j = 8000;
      }
      k = 0;
      while (k < j)
      {
        this.fInputBytes[k] = this.fRawInput[k];
        k += 1;
      }
      this.fInputLen = k;
    }
    Arrays.fill(this.fByteStats, (short)0);
    int j = 0;
    while (j < this.fInputLen)
    {
      k = this.fInputBytes[j] & 0xFF;
      short[] arrayOfShort = this.fByteStats;
      arrayOfShort[k] = ((short)(arrayOfShort[k] + 1));
      j += 1;
    }
    this.fC1Bytes = false;
    j = 128;
    while (j <= 159)
    {
      if (this.fByteStats[j] != 0)
      {
        this.fC1Bytes = true;
        return;
      }
      j += 1;
    }
  }
  
  public static String[] getAllDetectableCharsets()
  {
    String[] arrayOfString = new String[ALL_CS_RECOGNIZERS.size()];
    int i = 0;
    while (i < arrayOfString.length)
    {
      arrayOfString[i] = ((CharsetDetector.CSRecognizerInfo)ALL_CS_RECOGNIZERS.get(i)).recognizer.getName();
      i += 1;
    }
    return arrayOfString;
  }
  
  public CharsetMatch detect()
  {
    CharsetMatch[] arrayOfCharsetMatch = detectAll();
    if ((arrayOfCharsetMatch != null) && (arrayOfCharsetMatch.length != 0)) {
      return arrayOfCharsetMatch[0];
    }
    return null;
  }
  
  public CharsetMatch[] detectAll()
  {
    ArrayList localArrayList = new ArrayList();
    MungeInput();
    int i = 0;
    while (i < ALL_CS_RECOGNIZERS.size())
    {
      Object localObject = (CharsetDetector.CSRecognizerInfo)ALL_CS_RECOGNIZERS.get(i);
      boolean[] arrayOfBoolean = this.fEnabledRecognizers;
      boolean bool;
      if (arrayOfBoolean != null) {
        int j = arrayOfBoolean[i];
      } else {
        bool = ((CharsetDetector.CSRecognizerInfo)localObject).isDefaultEnabled;
      }
      if (bool)
      {
        localObject = ((CharsetDetector.CSRecognizerInfo)localObject).recognizer.match(this);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
      i += 1;
    }
    Collections.sort(localArrayList);
    Collections.reverse(localArrayList);
    return (CharsetMatch[])localArrayList.toArray(new CharsetMatch[localArrayList.size()]);
  }
  
  public boolean enableInputFilter(boolean paramBoolean)
  {
    boolean bool = this.fStripTags;
    this.fStripTags = paramBoolean;
    return bool;
  }
  
  @Deprecated
  public String[] getDetectableCharsets()
  {
    ArrayList localArrayList = new ArrayList(ALL_CS_RECOGNIZERS.size());
    int i = 0;
    while (i < ALL_CS_RECOGNIZERS.size())
    {
      CharsetDetector.CSRecognizerInfo localCSRecognizerInfo = (CharsetDetector.CSRecognizerInfo)ALL_CS_RECOGNIZERS.get(i);
      boolean[] arrayOfBoolean = this.fEnabledRecognizers;
      int j;
      if (arrayOfBoolean == null) {
        boolean bool = localCSRecognizerInfo.isDefaultEnabled;
      } else {
        j = arrayOfBoolean[i];
      }
      if (j != 0) {
        localArrayList.add(localCSRecognizerInfo.recognizer.getName());
      }
      i += 1;
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  public Reader getReader(InputStream paramInputStream, String paramString)
  {
    this.fDeclaredEncoding = paramString;
    try
    {
      setText(paramInputStream);
      paramInputStream = detect();
      if (paramInputStream == null) {
        return null;
      }
      paramInputStream = paramInputStream.getReader();
      return paramInputStream;
    }
    catch (IOException paramInputStream) {}
    return null;
  }
  
  public String getString(byte[] paramArrayOfByte, String paramString)
  {
    this.fDeclaredEncoding = paramString;
    try
    {
      setText(paramArrayOfByte);
      paramArrayOfByte = detect();
      if (paramArrayOfByte == null) {
        return null;
      }
      paramArrayOfByte = paramArrayOfByte.getString(-1);
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte) {}
    return null;
  }
  
  public boolean inputFilterEnabled()
  {
    return this.fStripTags;
  }
  
  public CharsetDetector setDeclaredEncoding(String paramString)
  {
    this.fDeclaredEncoding = paramString;
    return this;
  }
  
  @Deprecated
  public CharsetDetector setDetectableCharset(String paramString, boolean paramBoolean)
  {
    int m = 0;
    int i = 0;
    while (i < ALL_CS_RECOGNIZERS.size())
    {
      localObject = (CharsetDetector.CSRecognizerInfo)ALL_CS_RECOGNIZERS.get(i);
      if (((CharsetDetector.CSRecognizerInfo)localObject).recognizer.getName().equals(paramString))
      {
        j = i;
        if (((CharsetDetector.CSRecognizerInfo)localObject).isDefaultEnabled != paramBoolean) {
          break label74;
        }
        k = 1;
        break label80;
      }
      i += 1;
    }
    int j = -1;
    label74:
    int k = 0;
    i = j;
    label80:
    if (i >= 0)
    {
      if ((this.fEnabledRecognizers == null) && (k == 0))
      {
        this.fEnabledRecognizers = new boolean[ALL_CS_RECOGNIZERS.size()];
        j = m;
        while (j < ALL_CS_RECOGNIZERS.size())
        {
          this.fEnabledRecognizers[j] = ((CharsetDetector.CSRecognizerInfo)ALL_CS_RECOGNIZERS.get(j)).isDefaultEnabled;
          j += 1;
        }
      }
      paramString = this.fEnabledRecognizers;
      if (paramString != null) {
        paramString[i] = paramBoolean;
      }
      return this;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Invalid encoding: \"");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("\"");
    paramString = new IllegalArgumentException(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw paramString;
    }
  }
  
  public CharsetDetector setText(InputStream paramInputStream)
  {
    this.fInputStream = paramInputStream;
    paramInputStream = this.fInputStream;
    int i = 8000;
    paramInputStream.mark(8000);
    this.fRawInput = new byte[8000];
    this.fRawLength = 0;
    while (i > 0)
    {
      int j = this.fInputStream.read(this.fRawInput, this.fRawLength, i);
      if (j <= 0) {
        break;
      }
      this.fRawLength += j;
      i -= j;
    }
    this.fInputStream.reset();
    return this;
  }
  
  public CharsetDetector setText(byte[] paramArrayOfByte)
  {
    this.fRawInput = paramArrayOfByte;
    this.fRawLength = paramArrayOfByte.length;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetDetector
 * JD-Core Version:    0.7.0.1
 */