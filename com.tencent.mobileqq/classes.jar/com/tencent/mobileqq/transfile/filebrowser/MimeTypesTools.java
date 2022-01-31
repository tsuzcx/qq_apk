package com.tencent.mobileqq.transfile.filebrowser;

import android.content.Context;
import android.content.res.Resources;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public class MimeTypesTools
{
  private static MimeTypes jdField_a_of_type_ComTencentMobileqqTransfileFilebrowserMimeTypes;
  private static boolean jdField_a_of_type_Boolean;
  
  private static MimeTypes a(Context paramContext)
  {
    a(paramContext);
    return jdField_a_of_type_ComTencentMobileqqTransfileFilebrowserMimeTypes;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      str = paramString.toLowerCase();
    }
    return a(paramContext).a(str);
  }
  
  private static void a(Context paramContext)
  {
    MimeTypeParser localMimeTypeParser;
    if (!jdField_a_of_type_Boolean)
    {
      localMimeTypeParser = new MimeTypeParser();
      paramContext = paramContext.getResources().getXml(2131165187);
    }
    try
    {
      jdField_a_of_type_ComTencentMobileqqTransfileFilebrowserMimeTypes = localMimeTypeParser.a(paramContext);
      jdField_a_of_type_Boolean = true;
      return;
    }
    catch (XmlPullParserException paramContext)
    {
      throw new RuntimeException("PreselectedChannelsActivity: XmlPullParserException");
    }
    catch (IOException paramContext)
    {
      throw new RuntimeException("PreselectedChannelsActivity: IOException");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.filebrowser.MimeTypesTools
 * JD-Core Version:    0.7.0.1
 */