package com.tencent.mobileqq.triton.font;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TTFFile
{
  private Map<TTFTableName, TTFDirTabEntry> dirTabs;
  private final Set<String> familyNames = new HashSet();
  private FontFileReader fontFile;
  private String fullName = "";
  private String notice = "";
  private String postScriptName = "";
  private String subFamilyName = "";
  
  private void readDirTabs()
  {
    this.fontFile.readTTFLong();
    int j = this.fontFile.readTTFUShort();
    this.fontFile.skip(6L);
    this.dirTabs = new HashMap();
    TTFDirTabEntry[] arrayOfTTFDirTabEntry = new TTFDirTabEntry[j];
    int i = 0;
    while (i < j)
    {
      arrayOfTTFDirTabEntry[i] = new TTFDirTabEntry();
      String str = arrayOfTTFDirTabEntry[i].read(this.fontFile);
      this.dirTabs.put(TTFTableName.getValue(str), arrayOfTTFDirTabEntry[i]);
      i += 1;
    }
    this.dirTabs.put(TTFTableName.TABLE_DIRECTORY, new TTFDirTabEntry(0L, this.fontFile.getCurrentPos()));
  }
  
  private void readName()
  {
    seekTab(this.fontFile, TTFTableName.NAME, 2L);
    int k = this.fontFile.getCurrentPos();
    int i = this.fontFile.readTTFUShort();
    int m = this.fontFile.readTTFUShort();
    int j = k + 4;
    while (i > 0)
    {
      this.fontFile.seekSet(j);
      int n = this.fontFile.readTTFUShort();
      int i1 = this.fontFile.readTTFUShort();
      int i2 = this.fontFile.readTTFUShort();
      int i3 = this.fontFile.readTTFUShort();
      int i4 = this.fontFile.readTTFUShort();
      if (((n == 1) || (n == 3)) && ((i1 == 0) || (i1 == 1)))
      {
        Object localObject = this.fontFile;
        ((FontFileReader)localObject).seekSet(((FontFileReader)localObject).readTTFUShort() + (m + k - 2));
        if (n == 3) {
          localObject = this.fontFile.readTTFString(i4, i1);
        } else {
          localObject = this.fontFile.readTTFString(i4);
        }
        if (i3 != 0)
        {
          if (i3 != 1) {
            if (i3 != 2)
            {
              if (i3 != 4)
              {
                if (i3 != 6)
                {
                  if (i3 != 16) {
                    break label324;
                  }
                }
                else
                {
                  if (this.postScriptName.length() != 0) {
                    break label324;
                  }
                  this.postScriptName = ((String)localObject);
                  break label324;
                }
              }
              else
              {
                if ((this.fullName.length() != 0) && ((n != 3) || (i2 != 1033))) {
                  break label324;
                }
                this.fullName = ((String)localObject);
                break label324;
              }
            }
            else
            {
              if (this.subFamilyName.length() != 0) {
                break label324;
              }
              this.subFamilyName = ((String)localObject);
              break label324;
            }
          }
          this.familyNames.add(localObject);
        }
        else if (this.notice.length() == 0)
        {
          this.notice = ((String)localObject);
        }
      }
      label324:
      j += 12;
      i -= 1;
    }
  }
  
  private boolean seekTab(FontFileReader paramFontFileReader, TTFTableName paramTTFTableName, long paramLong)
  {
    paramTTFTableName = (TTFDirTabEntry)this.dirTabs.get(paramTTFTableName);
    if (paramTTFTableName == null) {
      return false;
    }
    paramFontFileReader.seekSet(paramTTFTableName.getOffset() + paramLong);
    return true;
  }
  
  public Set<String> getFamilyNames()
  {
    return this.familyNames;
  }
  
  public String getFullName()
  {
    return this.fullName;
  }
  
  public String getNotice()
  {
    return this.notice;
  }
  
  public String getPostScriptName()
  {
    return this.postScriptName;
  }
  
  public String getSubFamilyName()
  {
    return this.subFamilyName;
  }
  
  void readFont(FontFileReader paramFontFileReader)
  {
    this.fontFile = paramFontFileReader;
    readDirTabs();
    readName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.font.TTFFile
 * JD-Core Version:    0.7.0.1
 */