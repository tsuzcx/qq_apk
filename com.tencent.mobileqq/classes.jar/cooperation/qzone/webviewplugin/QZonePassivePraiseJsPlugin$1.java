package cooperation.qzone.webviewplugin;

import bghv;

public class QZonePassivePraiseJsPlugin$1
  implements Runnable
{
  public QZonePassivePraiseJsPlugin$1(bghv parambghv, String[] paramArrayOfString) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	cooperation/qzone/webviewplugin/QZonePassivePraiseJsPlugin$1:a	[Ljava/lang/String;
    //   4: ifnull +75 -> 79
    //   7: aload_0
    //   8: getfield 16	cooperation/qzone/webviewplugin/QZonePassivePraiseJsPlugin$1:a	[Ljava/lang/String;
    //   11: arraylength
    //   12: ifle +67 -> 79
    //   15: aload_0
    //   16: getfield 16	cooperation/qzone/webviewplugin/QZonePassivePraiseJsPlugin$1:a	[Ljava/lang/String;
    //   19: iconst_0
    //   20: aaload
    //   21: ifnull +58 -> 79
    //   24: new 25	org/json/JSONObject
    //   27: dup
    //   28: aload_0
    //   29: getfield 16	cooperation/qzone/webviewplugin/QZonePassivePraiseJsPlugin$1:a	[Ljava/lang/String;
    //   32: iconst_0
    //   33: aaload
    //   34: invokespecial 28	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   37: astore_2
    //   38: aload_2
    //   39: ldc 30
    //   41: invokevirtual 34	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   44: astore_1
    //   45: aload_0
    //   46: getfield 14	cooperation/qzone/webviewplugin/QZonePassivePraiseJsPlugin$1:this$0	Lbghv;
    //   49: aload_2
    //   50: ldc 36
    //   52: invokevirtual 34	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   55: invokestatic 41	bghv:a	(Lbghv;Ljava/lang/String;)Ljava/lang/String;
    //   58: pop
    //   59: aload_1
    //   60: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   63: ifne +16 -> 79
    //   66: aload_0
    //   67: getfield 14	cooperation/qzone/webviewplugin/QZonePassivePraiseJsPlugin$1:this$0	Lbghv;
    //   70: invokestatic 50	bghv:a	(Lbghv;)Ljava/lang/String;
    //   73: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   76: ifeq +15 -> 91
    //   79: return
    //   80: astore_2
    //   81: ldc 52
    //   83: astore_1
    //   84: aload_2
    //   85: invokevirtual 55	org/json/JSONException:printStackTrace	()V
    //   88: goto -29 -> 59
    //   91: invokestatic 60	bgbz:a	()Lbgbz;
    //   94: invokevirtual 63	bgbz:a	()Lbgcb;
    //   97: ldc 52
    //   99: aload_1
    //   100: invokevirtual 68	bgcb:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: return
    //   104: astore_2
    //   105: goto -21 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	1
    //   44	56	1	str	String
    //   37	13	2	localJSONObject	org.json.JSONObject
    //   80	5	2	localJSONException1	org.json.JSONException
    //   104	1	2	localJSONException2	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   24	45	80	org/json/JSONException
    //   45	59	104	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZonePassivePraiseJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */