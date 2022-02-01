package com.tencent.mobileqq.transfile.filebrowser;

import android.content.res.XmlResourceParser;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class MimeTypeParser
{
  public static final String ATTR_EXTENSION = "extension";
  public static final String ATTR_MIMETYPE = "mimetype";
  private static final String LOG_TAG = "MimeTypeParser";
  public static final String TAG_MIMETYPES = "MimeTypes";
  public static final String TAG_TYPE = "type";
  private MimeTypes mMimeTypes;
  private XmlPullParser mXpp;
  
  private void addMimeTypeStart()
  {
    String str1 = this.mXpp.getAttributeValue(null, "extension");
    String str2 = this.mXpp.getAttributeValue(null, "mimetype");
    this.mMimeTypes.put(str1, str2);
  }
  
  public MimeTypes fromXml(InputStream paramInputStream)
  {
    this.mXpp = XmlPullParserFactory.newInstance().newPullParser();
    this.mXpp.setInput(new InputStreamReader(paramInputStream));
    return parse();
  }
  
  public MimeTypes fromXmlResource(XmlResourceParser paramXmlResourceParser)
  {
    this.mXpp = paramXmlResourceParser;
    return parse();
  }
  
  public MimeTypes parse()
  {
    this.mMimeTypes = new MimeTypes();
    for (int i = this.mXpp.getEventType(); i != 1; i = this.mXpp.next())
    {
      String str = this.mXpp.getName();
      if (i == 2)
      {
        if ((!str.equals("MimeTypes")) && (str.equals("type"))) {
          addMimeTypeStart();
        }
      }
      else if (i == 3) {
        str.equals("MimeTypes");
      }
    }
    return this.mMimeTypes;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.filebrowser.MimeTypeParser
 * JD-Core Version:    0.7.0.1
 */