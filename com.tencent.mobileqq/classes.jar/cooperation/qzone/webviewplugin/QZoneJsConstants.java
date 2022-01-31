package cooperation.qzone.webviewplugin;

public class QZoneJsConstants
{
  public static String a;
  public static String[] a;
  public static String b;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  public static String h;
  
  static
  {
    jdField_a_of_type_JavaLangString = "JsFamousShare";
    b = "famousShareToQQFriend";
    c = "famousShareToQzone";
    d = "famousShareToWxFriend";
    e = "famousShareToWxPengyouquan";
    f = "famousJubao";
    g = "setUserHomePageMsgBoardGate";
    h = "writeMood";
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "setDefaultFont", "OpenCustomVipSucc", "SetPlayerDeco", "SetPersonalizeFinished", "setAvatar", "setcardfinish", "setFloat" };
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneJsConstants
 * JD-Core Version:    0.7.0.1
 */