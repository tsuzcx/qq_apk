package com.tencent.plato;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class PlatoAppJson
{
  public static final String DEFAULT = "defalut";
  public static final int FAULT_TIMPS = 1;
  public static final int FAULT_WEB = 0;
  private static String TAG = "PlatoAppJson";
  public static final String UPDATE_NEWEST = "newest";
  public static final String UPDATE_NORMAL = "normal";
  public static final String UPDATE_TIMEOUT = "timeout";
  private int apiLevel;
  private ArrayList apiSpec = new ArrayList();
  private String backgroundColor;
  public String bid;
  private boolean debug = true;
  private int falutModel = 0;
  private boolean fullscreen;
  private boolean gray;
  private JSONObject mAppJSON;
  public ArrayList mPageIds = new ArrayList();
  private String name;
  private String navigationBarBackgroundColor;
  private String navigationBarTextStyle;
  private String navigationBarTitleText;
  private String pageMain;
  private String updateModel = "normal";
  private int version;
  
  public PlatoAppJson(String paramString)
  {
    this.bid = paramString;
    this.mAppJSON = createJSONObject(paramString);
    if (this.mAppJSON == null)
    {
      this.name = "";
      this.pageMain = "App";
      this.version = 0;
      this.fullscreen = false;
      this.apiLevel = 2;
      this.falutModel = 0;
      this.gray = false;
      this.debug = true;
      this.updateModel = "newest";
      this.navigationBarBackgroundColor = "defalut";
      this.navigationBarTextStyle = "defalut";
      this.navigationBarTitleText = "";
      this.backgroundColor = "defalut";
      return;
    }
    this.name = this.mAppJSON.optString("name");
    this.pageMain = this.mAppJSON.optString("page_main", "App");
    this.version = this.mAppJSON.optInt("version", 0);
    this.fullscreen = this.mAppJSON.optBoolean("fullscreen", false);
    this.apiLevel = this.mAppJSON.optInt("apl_level", 2);
    this.falutModel = this.mAppJSON.optInt("falut", 0);
    this.gray = this.mAppJSON.optBoolean("gray", false);
    this.debug = this.mAppJSON.optBoolean("debug", true);
    this.updateModel = this.mAppJSON.optString("update", "newest");
    paramString = this.mAppJSON.optJSONArray("api_spec");
    while (i < paramString.length())
    {
      this.apiSpec.add(paramString.optString(i));
      i += 1;
    }
    paramString = this.mAppJSON.optJSONObject("window");
    this.navigationBarBackgroundColor = paramString.optString("navigationBarBackgroundColor", "defalut");
    this.navigationBarTextStyle = paramString.optString("navigationBarTextStyle", "defalut");
    this.navigationBarTitleText = paramString.optString("navigationBarTitleText", "");
    this.backgroundColor = paramString.optString("backgroundColor", "defalut");
  }
  
  /* Error */
  protected static JSONObject createJSONObject(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 169	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 171	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: ldc 173
    //   16: invokestatic 178	com/tencent/plato/PlatoAppManager:getAbsFilePath	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   19: invokespecial 180	java/io/File:<init>	(Ljava/lang/String;)V
    //   22: astore_0
    //   23: aload_0
    //   24: invokevirtual 184	java/io/File:exists	()Z
    //   27: ifeq -20 -> 7
    //   30: new 186	java/io/FileInputStream
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 189	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   38: astore_0
    //   39: aload_0
    //   40: ifnull -33 -> 7
    //   43: aload_0
    //   44: invokestatic 195	com/tencent/biz/common/util/Util:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   47: astore_1
    //   48: aload_0
    //   49: invokevirtual 200	java/io/InputStream:close	()V
    //   52: new 102	org/json/JSONObject
    //   55: dup
    //   56: aload_1
    //   57: invokespecial 201	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   60: astore_0
    //   61: aload_0
    //   62: areturn
    //   63: astore_0
    //   64: aload_0
    //   65: invokevirtual 204	java/io/IOException:printStackTrace	()V
    //   68: aconst_null
    //   69: astore_0
    //   70: goto -31 -> 39
    //   73: astore_0
    //   74: aload_0
    //   75: invokevirtual 204	java/io/IOException:printStackTrace	()V
    //   78: goto -26 -> 52
    //   81: astore_0
    //   82: getstatic 49	com/tencent/plato/PlatoAppJson:TAG	Ljava/lang/String;
    //   85: iconst_0
    //   86: new 206	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   93: ldc 209
    //   95: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload_0
    //   99: invokevirtual 217	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   102: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 226	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: aconst_null
    //   112: areturn
    //   113: astore_0
    //   114: getstatic 49	com/tencent/plato/PlatoAppJson:TAG	Ljava/lang/String;
    //   117: iconst_0
    //   118: new 206	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   125: ldc 209
    //   127: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_0
    //   131: invokevirtual 227	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   134: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 226	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   143: aconst_null
    //   144: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	paramString	String
    //   47	10	1	str	String
    // Exception table:
    //   from	to	target	type
    //   30	39	63	java/io/IOException
    //   48	52	73	java/io/IOException
    //   52	61	81	org/json/JSONException
    //   52	61	113	java/lang/Exception
  }
  
  public void addPageId(int paramInt)
  {
    this.mPageIds.add(Integer.valueOf(paramInt));
  }
  
  public int getApiLevel()
  {
    return this.apiLevel;
  }
  
  public ArrayList getApiSpec()
  {
    return this.apiSpec;
  }
  
  public String getBackgroundColor()
  {
    return this.backgroundColor;
  }
  
  public int getFalutModel()
  {
    return this.falutModel;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getNavigationBarBackgroundColor()
  {
    return this.navigationBarBackgroundColor;
  }
  
  public String getNavigationBarTextStyle()
  {
    return this.navigationBarTextStyle;
  }
  
  public String getNavigationBarTitleText()
  {
    return this.navigationBarTitleText;
  }
  
  public String getPageMain()
  {
    return this.pageMain;
  }
  
  public String getUpdateModel()
  {
    return this.updateModel;
  }
  
  public int getVersion()
  {
    return this.version;
  }
  
  public boolean isDebug()
  {
    return this.debug;
  }
  
  public boolean isFullscreen()
  {
    return this.fullscreen;
  }
  
  public boolean isGray()
  {
    return this.gray;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.plato.PlatoAppJson
 * JD-Core Version:    0.7.0.1
 */