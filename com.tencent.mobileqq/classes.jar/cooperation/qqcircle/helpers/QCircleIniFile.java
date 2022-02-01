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
    for (;;)
    {
      int i;
      try
      {
        if (this.lineSeparator == null) {
          break label222;
        }
        if (!this.lineSeparator.trim().equals("")) {
          break label217;
        }
      }
      catch (IOException paramBufferedWriter)
      {
        Iterator localIterator;
        Object localObject;
        Map.Entry localEntry;
        paramBufferedWriter.printStackTrace();
        return;
      }
      localIterator = this.sections.values().iterator();
      if (localIterator.hasNext())
      {
        localObject = (QCircleIniFile.Section)localIterator.next();
        paramBufferedWriter.write("[" + ((QCircleIniFile.Section)localObject).getName() + "]");
        if (i != 0)
        {
          paramBufferedWriter.write(this.lineSeparator);
          localObject = ((QCircleIniFile.Section)localObject).getValues().entrySet().iterator();
          if (!((Iterator)localObject).hasNext()) {
            break label210;
          }
          localEntry = (Map.Entry)((Iterator)localObject).next();
          paramBufferedWriter.write((String)localEntry.getKey());
          paramBufferedWriter.write("=");
          paramBufferedWriter.write(localEntry.getValue().toString());
          if (i != 0)
          {
            paramBufferedWriter.write(this.lineSeparator);
            continue;
          }
        }
        else
        {
          paramBufferedWriter.newLine();
          continue;
        }
        paramBufferedWriter.newLine();
      }
      else
      {
        label210:
        paramBufferedWriter.close();
        return;
        label217:
        i = 0;
        continue;
        label222:
        i = 1;
      }
    }
  }
  
  /* Error */
  private void toIniFile(BufferedReader paramBufferedReader)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 158
    //   4: invokestatic 164	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   7: astore_3
    //   8: aload_1
    //   9: invokevirtual 167	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   12: astore 4
    //   14: aload 4
    //   16: ifnull +114 -> 130
    //   19: aload_3
    //   20: aload 4
    //   22: invokevirtual 171	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   25: invokevirtual 176	java/util/regex/Matcher:matches	()Z
    //   28: ifeq +64 -> 92
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
    //   82: astore_2
    //   83: aload_2
    //   84: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   87: aload_1
    //   88: invokevirtual 198	java/io/BufferedReader:close	()V
    //   91: return
    //   92: aload 4
    //   94: ldc 145
    //   96: invokevirtual 202	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   99: astore 4
    //   101: aload 4
    //   103: arraylength
    //   104: iconst_2
    //   105: if_icmpne -97 -> 8
    //   108: aload_2
    //   109: aload 4
    //   111: iconst_0
    //   112: aaload
    //   113: aload 4
    //   115: iconst_1
    //   116: aaload
    //   117: invokevirtual 206	cooperation/qqcircle/helpers/QCircleIniFile$Section:set	(Ljava/lang/String;Ljava/lang/Object;)V
    //   120: goto -112 -> 8
    //   123: astore_2
    //   124: aload_1
    //   125: invokevirtual 198	java/io/BufferedReader:close	()V
    //   128: aload_2
    //   129: athrow
    //   130: aload_1
    //   131: invokevirtual 198	java/io/BufferedReader:close	()V
    //   134: return
    //   135: astore_1
    //   136: aload_1
    //   137: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   140: return
    //   141: astore_1
    //   142: aload_1
    //   143: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   146: return
    //   147: astore_1
    //   148: aload_1
    //   149: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   152: goto -24 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	this	QCircleIniFile
    //   0	155	1	paramBufferedReader	BufferedReader
    //   1	72	2	localSection	QCircleIniFile.Section
    //   82	27	2	localIOException	IOException
    //   123	6	2	localObject1	Object
    //   7	13	3	localPattern	java.util.regex.Pattern
    //   12	102	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   8	14	82	java/io/IOException
    //   19	79	82	java/io/IOException
    //   92	120	82	java/io/IOException
    //   8	14	123	finally
    //   19	79	123	finally
    //   83	87	123	finally
    //   92	120	123	finally
    //   130	134	135	java/io/IOException
    //   87	91	141	java/io/IOException
    //   124	128	147	java/io/IOException
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
      if ((paramString1 == null) || (paramString1.toString().trim().equals(""))) {
        return paramString3;
      }
      return paramString1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.helpers.QCircleIniFile
 * JD-Core Version:    0.7.0.1
 */