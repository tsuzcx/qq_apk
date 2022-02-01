package cooperation.qqcircle.helpers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class QCircleIniFile
{
  private String charSet = "UTF-8";
  private File file = null;
  private String lineSeparator = null;
  private Map<String, QCircleIniFile.Section> sections = new LinkedHashMap();
  
  public QCircleIniFile() {}
  
  public QCircleIniFile(File paramFile)
  {
    this.file = paramFile;
    initFromFile(paramFile);
  }
  
  public QCircleIniFile(InputStream paramInputStream)
  {
    initFromInputStream(paramInputStream);
  }
  
  private void initFromFile(File paramFile)
  {
    try
    {
      toIniFile(new BufferedReader(new FileReader(paramFile)));
      return;
    }
    catch (FileNotFoundException paramFile)
    {
      paramFile.printStackTrace();
    }
  }
  
  private void initFromInputStream(InputStream paramInputStream)
  {
    try
    {
      toIniFile(new BufferedReader(new InputStreamReader(paramInputStream, this.charSet)));
      return;
    }
    catch (UnsupportedEncodingException paramInputStream)
    {
      paramInputStream.printStackTrace();
    }
  }
  
  private void saveConfig(BufferedWriter paramBufferedWriter)
  {
    for (int i = 0;; i = 1) {
      try
      {
        if ((this.lineSeparator != null) && (!this.lineSeparator.trim().equals("")))
        {
          Iterator localIterator = this.sections.values().iterator();
          while (localIterator.hasNext())
          {
            Object localObject1 = (QCircleIniFile.Section)localIterator.next();
            Object localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("[");
            ((StringBuilder)localObject2).append(((QCircleIniFile.Section)localObject1).getName());
            ((StringBuilder)localObject2).append("]");
            paramBufferedWriter.write(((StringBuilder)localObject2).toString());
            if (i != 0) {
              paramBufferedWriter.write(this.lineSeparator);
            } else {
              paramBufferedWriter.newLine();
            }
            localObject1 = ((QCircleIniFile.Section)localObject1).getValues().entrySet().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (Map.Entry)((Iterator)localObject1).next();
              paramBufferedWriter.write((String)((Map.Entry)localObject2).getKey());
              paramBufferedWriter.write("=");
              paramBufferedWriter.write(((Map.Entry)localObject2).getValue().toString());
              if (i != 0) {
                paramBufferedWriter.write(this.lineSeparator);
              } else {
                paramBufferedWriter.newLine();
              }
            }
          }
          paramBufferedWriter.close();
          return;
        }
      }
      catch (IOException paramBufferedWriter)
      {
        paramBufferedWriter.printStackTrace();
        return;
      }
    }
  }
  
  /* Error */
  private void toIniFile(BufferedReader paramBufferedReader)
  {
    // Byte code:
    //   0: ldc 158
    //   2: invokestatic 164	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   5: astore_3
    //   6: aconst_null
    //   7: astore_2
    //   8: aload_1
    //   9: invokevirtual 167	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   12: astore 4
    //   14: aload 4
    //   16: ifnull +97 -> 113
    //   19: aload_3
    //   20: aload 4
    //   22: invokevirtual 171	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   25: invokevirtual 176	java/util/regex/Matcher:matches	()Z
    //   28: ifeq +54 -> 82
    //   31: aload 4
    //   33: invokevirtual 74	java/lang/String:trim	()Ljava/lang/String;
    //   36: astore 4
    //   38: new 104	cooperation/qqcircle/helpers/QCircleIniFile$Section
    //   41: dup
    //   42: invokespecial 177	cooperation/qqcircle/helpers/QCircleIniFile$Section:<init>	()V
    //   45: astore_2
    //   46: aload_2
    //   47: aload 4
    //   49: iconst_1
    //   50: aload 4
    //   52: invokevirtual 181	java/lang/String:length	()I
    //   55: iconst_1
    //   56: isub
    //   57: invokevirtual 185	java/lang/String:substring	(II)Ljava/lang/String;
    //   60: invokestatic 189	cooperation/qqcircle/helpers/QCircleIniFile$Section:access$002	(Lcooperation/qqcircle/helpers/QCircleIniFile$Section;Ljava/lang/String;)Ljava/lang/String;
    //   63: pop
    //   64: aload_0
    //   65: getfield 27	cooperation/qqcircle/helpers/QCircleIniFile:sections	Ljava/util/Map;
    //   68: aload_2
    //   69: invokestatic 193	cooperation/qqcircle/helpers/QCircleIniFile$Section:access$000	(Lcooperation/qqcircle/helpers/QCircleIniFile$Section;)Ljava/lang/String;
    //   72: aload_2
    //   73: invokeinterface 197 3 0
    //   78: pop
    //   79: goto -71 -> 8
    //   82: aload 4
    //   84: ldc 148
    //   86: invokevirtual 201	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   89: astore 4
    //   91: aload 4
    //   93: arraylength
    //   94: iconst_2
    //   95: if_icmpne -87 -> 8
    //   98: aload_2
    //   99: aload 4
    //   101: iconst_0
    //   102: aaload
    //   103: aload 4
    //   105: iconst_1
    //   106: aaload
    //   107: invokevirtual 205	cooperation/qqcircle/helpers/QCircleIniFile$Section:set	(Ljava/lang/String;Ljava/lang/Object;)V
    //   110: goto -102 -> 8
    //   113: aload_1
    //   114: invokevirtual 206	java/io/BufferedReader:close	()V
    //   117: return
    //   118: astore_1
    //   119: aload_1
    //   120: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   123: return
    //   124: astore_2
    //   125: goto +13 -> 138
    //   128: astore_2
    //   129: aload_2
    //   130: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   133: aload_1
    //   134: invokevirtual 206	java/io/BufferedReader:close	()V
    //   137: return
    //   138: aload_1
    //   139: invokevirtual 206	java/io/BufferedReader:close	()V
    //   142: goto +8 -> 150
    //   145: astore_1
    //   146: aload_1
    //   147: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   150: goto +5 -> 155
    //   153: aload_2
    //   154: athrow
    //   155: goto -2 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	QCircleIniFile
    //   0	158	1	paramBufferedReader	BufferedReader
    //   7	92	2	localSection	QCircleIniFile.Section
    //   124	1	2	localObject1	Object
    //   128	26	2	localIOException	IOException
    //   5	15	3	localPattern	java.util.regex.Pattern
    //   12	92	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   113	117	118	java/io/IOException
    //   133	137	118	java/io/IOException
    //   8	14	124	finally
    //   19	79	124	finally
    //   82	110	124	finally
    //   129	133	124	finally
    //   8	14	128	java/io/IOException
    //   19	79	128	java/io/IOException
    //   82	110	128	java/io/IOException
    //   138	142	145	java/io/IOException
  }
  
  public QCircleIniFile.Section get(String paramString)
  {
    return (QCircleIniFile.Section)this.sections.get(paramString);
  }
  
  public Object get(String paramString1, String paramString2)
  {
    return get(paramString1, paramString2, null);
  }
  
  public Object get(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = (QCircleIniFile.Section)this.sections.get(paramString1);
    if (paramString1 != null)
    {
      paramString1 = paramString1.get(paramString2);
      if (paramString1 != null)
      {
        if (paramString1.toString().trim().equals("")) {
          return paramString3;
        }
        return paramString1;
      }
      return paramString3;
    }
    return null;
  }
  
  public void load(File paramFile)
  {
    this.file = paramFile;
    initFromFile(paramFile);
  }
  
  public void load(InputStream paramInputStream)
  {
    initFromInputStream(paramInputStream);
  }
  
  public void remove(String paramString)
  {
    this.sections.remove(paramString);
  }
  
  public void remove(String paramString1, String paramString2)
  {
    paramString1 = (QCircleIniFile.Section)this.sections.get(paramString1);
    if (paramString1 != null) {
      paramString1.getValues().remove(paramString2);
    }
  }
  
  public void save()
  {
    save(this.file);
  }
  
  public void save(File paramFile)
  {
    try
    {
      saveConfig(new BufferedWriter(new FileWriter(paramFile)));
      return;
    }
    catch (IOException paramFile)
    {
      paramFile.printStackTrace();
    }
  }
  
  public void save(OutputStream paramOutputStream)
  {
    try
    {
      saveConfig(new BufferedWriter(new OutputStreamWriter(paramOutputStream, this.charSet)));
      return;
    }
    catch (UnsupportedEncodingException paramOutputStream)
    {
      paramOutputStream.printStackTrace();
    }
  }
  
  public void set(String paramString1, String paramString2, Object paramObject)
  {
    QCircleIniFile.Section localSection2 = (QCircleIniFile.Section)this.sections.get(paramString1);
    QCircleIniFile.Section localSection1 = localSection2;
    if (localSection2 == null) {
      localSection1 = new QCircleIniFile.Section();
    }
    QCircleIniFile.Section.access$002(localSection1, paramString1);
    localSection1.set(paramString2, paramObject);
    this.sections.put(paramString1, localSection1);
  }
  
  public void setCharSet(String paramString)
  {
    this.charSet = paramString;
  }
  
  public void setLineSeparator(String paramString)
  {
    this.lineSeparator = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.helpers.QCircleIniFile
 * JD-Core Version:    0.7.0.1
 */