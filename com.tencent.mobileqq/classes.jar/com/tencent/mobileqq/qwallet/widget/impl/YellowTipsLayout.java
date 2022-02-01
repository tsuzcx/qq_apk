package com.tencent.mobileqq.qwallet.widget.impl;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qqpay.impl.R.id;
import com.tencent.mobileqq.qqpay.impl.R.layout;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

public class YellowTipsLayout
  extends FrameLayout
  implements View.OnClickListener
{
  private ImageView a;
  private TextView b;
  private ImageView c;
  private String d;
  
  public YellowTipsLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public YellowTipsLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  /* Error */
  public static JSONObject a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 30	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 33	org/json/JSONObject:<init>	()V
    //   7: astore 4
    //   9: new 35	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   16: astore_0
    //   17: aload_0
    //   18: ldc 38
    //   20: invokestatic 44	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   23: checkcast 38	cooperation/qwallet/plugin/IQWalletHelper
    //   26: invokeinterface 48 1 0
    //   31: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_0
    //   36: aload_1
    //   37: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload_0
    //   42: ldc 54
    //   44: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: new 56	java/io/File
    //   51: dup
    //   52: aload_0
    //   53: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   59: astore_0
    //   60: aload_0
    //   61: invokevirtual 66	java/io/File:exists	()Z
    //   64: ifeq +161 -> 225
    //   67: new 68	java/io/FileInputStream
    //   70: dup
    //   71: aload_0
    //   72: invokespecial 71	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   75: astore_1
    //   76: aload_1
    //   77: astore_0
    //   78: sipush 1024
    //   81: newarray byte
    //   83: astore_3
    //   84: aload_1
    //   85: astore_0
    //   86: new 35	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   93: astore 5
    //   95: aload_1
    //   96: astore_0
    //   97: aload_1
    //   98: aload_3
    //   99: invokevirtual 75	java/io/FileInputStream:read	([B)I
    //   102: istore_2
    //   103: iload_2
    //   104: ifle +24 -> 128
    //   107: aload_1
    //   108: astore_0
    //   109: aload 5
    //   111: new 77	java/lang/String
    //   114: dup
    //   115: aload_3
    //   116: iconst_0
    //   117: iload_2
    //   118: invokespecial 80	java/lang/String:<init>	([BII)V
    //   121: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: goto -30 -> 95
    //   128: aload_1
    //   129: astore_0
    //   130: new 30	org/json/JSONObject
    //   133: dup
    //   134: new 77	java/lang/String
    //   137: dup
    //   138: aload 5
    //   140: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: iconst_0
    //   144: invokestatic 86	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   147: invokespecial 89	java/lang/String:<init>	([B)V
    //   150: invokespecial 90	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   153: astore_3
    //   154: aload_1
    //   155: invokevirtual 93	java/io/FileInputStream:close	()V
    //   158: goto +8 -> 166
    //   161: astore_0
    //   162: aload_0
    //   163: invokevirtual 96	java/io/IOException:printStackTrace	()V
    //   166: aload_3
    //   167: areturn
    //   168: astore_3
    //   169: goto +12 -> 181
    //   172: astore_1
    //   173: aconst_null
    //   174: astore_0
    //   175: goto +32 -> 207
    //   178: astore_3
    //   179: aconst_null
    //   180: astore_1
    //   181: aload_1
    //   182: astore_0
    //   183: aload_3
    //   184: invokevirtual 97	java/lang/Exception:printStackTrace	()V
    //   187: aload_1
    //   188: ifnull +37 -> 225
    //   191: aload_1
    //   192: invokevirtual 93	java/io/FileInputStream:close	()V
    //   195: aload 4
    //   197: areturn
    //   198: astore_0
    //   199: aload_0
    //   200: invokevirtual 96	java/io/IOException:printStackTrace	()V
    //   203: aload 4
    //   205: areturn
    //   206: astore_1
    //   207: aload_0
    //   208: ifnull +15 -> 223
    //   211: aload_0
    //   212: invokevirtual 93	java/io/FileInputStream:close	()V
    //   215: goto +8 -> 223
    //   218: astore_0
    //   219: aload_0
    //   220: invokevirtual 96	java/io/IOException:printStackTrace	()V
    //   223: aload_1
    //   224: athrow
    //   225: aload 4
    //   227: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	paramContext	Context
    //   0	228	1	paramString	String
    //   102	16	2	i	int
    //   83	84	3	localObject	Object
    //   168	1	3	localException1	Exception
    //   178	6	3	localException2	Exception
    //   7	219	4	localJSONObject	JSONObject
    //   93	46	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   154	158	161	java/io/IOException
    //   78	84	168	java/lang/Exception
    //   86	95	168	java/lang/Exception
    //   97	103	168	java/lang/Exception
    //   109	125	168	java/lang/Exception
    //   130	154	168	java/lang/Exception
    //   67	76	172	finally
    //   67	76	178	java/lang/Exception
    //   191	195	198	java/io/IOException
    //   78	84	206	finally
    //   86	95	206	finally
    //   97	103	206	finally
    //   109	125	206	finally
    //   130	154	206	finally
    //   183	187	206	finally
    //   211	215	218	java/io/IOException
  }
  
  private void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(R.layout.a, this, true);
    paramContext.setClickable(true);
    paramContext.setOnClickListener(this);
    this.a = ((ImageView)findViewById(R.id.c));
    this.b = ((TextView)findViewById(R.id.b));
    this.c = ((ImageView)findViewById(R.id.a));
  }
  
  public boolean a(JSONObject paramJSONObject, String paramString)
  {
    setVisibility(8);
    boolean bool = false;
    if (paramJSONObject == null) {
      return false;
    }
    try
    {
      Object localObject = paramJSONObject.optJSONObject(paramString);
      if (localObject == null) {
        return false;
      }
      paramJSONObject = ((JSONObject)localObject).optString("ad_text");
      paramString = ((JSONObject)localObject).optString("ad_url");
      String str1 = ((JSONObject)localObject).optString("ad_level");
      String str2 = ((JSONObject)localObject).optString("ad_begin_time");
      localObject = ((JSONObject)localObject).optString("ad_end_time");
      if ((!TextUtils.isEmpty(paramJSONObject)) && (!TextUtils.isEmpty(str2)))
      {
        if (TextUtils.isEmpty(str2)) {
          return false;
        }
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long l1 = localSimpleDateFormat.parse(str2).getTime();
        long l2 = localSimpleDateFormat.parse((String)localObject).getTime();
        long l3 = System.currentTimeMillis();
        if (l3 >= l1)
        {
          if (l3 > l2) {
            return false;
          }
          setVisibility(0);
          this.b.setText(paramJSONObject);
          setUrl(paramString);
          set_ad_level(str1);
          break label188;
        }
      }
      return false;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      label188:
      if (getVisibility() == 0) {
        bool = true;
      }
    }
    return bool;
  }
  
  public void onClick(View paramView)
  {
    if (this.d != null)
    {
      Intent localIntent = new Intent();
      paramView = paramView.getContext();
      localIntent.putExtra("url", this.d);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("hide_more_button", true);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      RouteUtils.a(paramView, localIntent, "/base/browser");
    }
  }
  
  public void setArrowVisible(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.c.getVisibility() != 0) {
        this.c.setVisibility(0);
      }
    }
    else if (this.c.getVisibility() == 0) {
      this.c.setVisibility(4);
    }
  }
  
  public void setMessage(String paramString)
  {
    this.b.setText(paramString);
  }
  
  public void setUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      setArrowVisible(false);
      this.d = null;
      return;
    }
    setArrowVisible(true);
    this.d = paramString;
  }
  
  public void setWarningVisible(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.a.getVisibility() != 0) {
        this.a.setVisibility(0);
      }
    }
    else if (this.a.getVisibility() == 0) {
      this.a.setVisibility(4);
    }
  }
  
  public void set_ad_level(String paramString)
  {
    if ((paramString != null) && ("info".equals(paramString)))
    {
      setWarningVisible(false);
      return;
    }
    setWarningVisible(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.widget.impl.YellowTipsLayout
 * JD-Core Version:    0.7.0.1
 */