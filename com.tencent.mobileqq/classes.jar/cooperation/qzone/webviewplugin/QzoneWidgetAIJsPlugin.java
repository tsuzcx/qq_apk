package cooperation.qzone.webviewplugin;

import ando;
import andp;
import andq;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.util.Base64;
import android.util.DisplayMetrics;
import com.google.zxing.common.BitMatrix;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.open.base.BitmapUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import cooperation.qzone.widgetai.WidgetAIFileUtil;
import org.json.JSONArray;
import org.json.JSONObject;

public class QzoneWidgetAIJsPlugin
  extends QzoneInternalWebViewPlugin
{
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int k = paramOptions.outHeight;
    int m = paramOptions.outWidth;
    int j = 1;
    int i = 1;
    if ((k > paramInt2) || (m > paramInt1))
    {
      k /= 2;
      m /= 2;
      for (;;)
      {
        j = i;
        if (k / i <= paramInt2) {
          break;
        }
        j = i;
        if (m / i <= paramInt1) {
          break;
        }
        i *= 2;
      }
    }
    return j;
  }
  
  public static Bitmap a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    System.currentTimeMillis();
    Object localObject = QRUtils.a(paramString, -1);
    int m = ((BitMatrix)localObject).a();
    paramString = new int[m * m];
    int i = 0;
    while (i < m)
    {
      int j = 0;
      if (j < m)
      {
        if (((BitMatrix)localObject).a(j, i)) {}
        for (int k = -16777216;; k = 16777215)
        {
          paramString[(i * m + j)] = k;
          j += 1;
          break;
        }
      }
      i += 1;
    }
    localObject = Bitmap.createBitmap(m, m, Bitmap.Config.ARGB_8888);
    ((Bitmap)localObject).setPixels(paramString, 0, m, 0, 0, m, m);
    try
    {
      paramString = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      if (paramString == null)
      {
        ((Bitmap)localObject).recycle();
        return null;
      }
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        System.gc();
        try
        {
          paramString = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        }
        catch (OutOfMemoryError paramString)
        {
          return null;
        }
      }
      Canvas localCanvas = new Canvas(paramString);
      Paint localPaint = new Paint();
      localPaint.setShader(new LinearGradient(0.0F, 0.0F, 0.0F, 600.0F, -657931, -1513240, Shader.TileMode.REPEAT));
      localCanvas.drawRect(0.0F, 0.0F, paramInt1, paramInt2, localPaint);
      localCanvas.drawBitmap((Bitmap)localObject, null, new Rect(paramInt3, paramInt3, paramInt1 - paramInt3, paramInt2 - paramInt3), null);
      ((Bitmap)localObject).recycle();
      System.currentTimeMillis();
    }
    return paramString;
  }
  
  private Bitmap a(byte[] paramArrayOfByte)
  {
    Object localObject = null;
    int i = 1024;
    label83:
    for (;;)
    {
      try
      {
        if (paramArrayOfByte.length != 0)
        {
          if (this.a.mRuntime.a() != null)
          {
            localObject = this.a.mRuntime.a().getResources();
            if (localObject == null) {
              break label83;
            }
            j = ((Resources)localObject).getDisplayMetrics().widthPixels;
            i = ((Resources)localObject).getDisplayMetrics().heightPixels;
            localObject = a(paramArrayOfByte, j, i);
          }
        }
        else {
          return localObject;
        }
        localObject = null;
        continue;
        int j = 1024;
      }
      catch (Exception paramArrayOfByte)
      {
        return null;
      }
    }
  }
  
  public static Bitmap a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = BitmapUtil.a();
    localOptions.inJustDecodeBounds = true;
    try
    {
      BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
      localOptions.inSampleSize = a(localOptions, paramInt1, paramInt2);
      localOptions.inJustDecodeBounds = false;
      return a(paramArrayOfByte, localOptions, 0, 2);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  private static Bitmap a(byte[] paramArrayOfByte, BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    Object localObject = null;
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, paramOptions);
      localObject = localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (paramInt1 >= paramInt2) {}
      paramOptions.inSampleSize += 1;
    }
    return localObject;
    return a(paramArrayOfByte, paramOptions, paramInt1 + 1, paramInt2);
  }
  
  public static String a()
  {
    String str2 = String.valueOf(System.currentTimeMillis());
    String str1 = str2;
    if (str2.length() > 6) {
      str1 = str2.substring(str2.length() - 6, str2.length());
    }
    return str1;
  }
  
  private String a(String paramString)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    int i;
    do
    {
      do
      {
        do
        {
          return str;
          str = paramString;
        } while (!paramString.startsWith("data:image"));
        i = paramString.indexOf("base64,");
        str = paramString;
      } while (i < 0);
      str = paramString;
    } while ("base64,".length() + i >= paramString.length());
    return paramString.substring("base64,".length() + i);
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    int i;
    String str;
    for (;;)
    {
      return;
      i = paramJSONObject.optInt("shareType");
      Object localObject1 = paramJSONObject.optString("url");
      try
      {
        Object localObject2 = paramJSONObject.getJSONArray("images");
        str = paramJSONObject.optString("content");
        paramJSONObject.optString("tagTitle");
        paramJSONObject.optInt("quality");
        localObject2 = a(Base64.decode(a(((JSONArray)localObject2).optString(0)), 0));
        if (localObject2 != null)
        {
          paramJSONObject = paramJSONObject.getJSONArray("qr_rect");
          int k = (int)(paramJSONObject.optDouble(0) * ((Bitmap)localObject2).getWidth());
          int n = (int)(paramJSONObject.optDouble(1) * ((Bitmap)localObject2).getHeight());
          int m = (int)(paramJSONObject.optDouble(2) * ((Bitmap)localObject2).getWidth());
          int j = (int)(paramJSONObject.optDouble(3) * ((Bitmap)localObject2).getHeight());
          k -= (int)(m * 0.1D);
          n -= (int)(j * 0.1D);
          m = (int)(m * 1.2D);
          j = (int)(j * 1.2D);
          paramJSONObject = a((String)localObject1, m, j, 0);
          localObject1 = WidgetAIFileUtil.a((Bitmap)localObject2, WidgetAIFileUtil.a(m + 8, j + 8), k - 4, n - 4, 1);
          if (localObject1 != null)
          {
            paramJSONObject = WidgetAIFileUtil.a((Bitmap)localObject1, paramJSONObject, k, n, 1);
            if (paramJSONObject == null)
            {
              QLog.d("QzoneWidgetAIJsPlugin", 2, "generate QRBitmap failed!");
              return;
            }
          }
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return;
      }
    }
    ThreadManager.executeOnSubThread(new andp(this, i, WidgetAIFileUtil.a("QzoneShowShare" + a() + ".png", paramJSONObject, this.a.mRuntime.a()), str));
  }
  
  private void a(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length < 1)) {
      QLog.d("QzoneWidgetAIJsPlugin", 1, "QzoneWidgetAI.handleShareWidgetAiGifAnimation args is empty");
    }
    do
    {
      return;
      QLog.i("QzoneWidgetAIJsPlugin", 1, "publish gif mood start");
      ThreadManager.executeOnSubThread(new andq(this, paramVarArgs[0]));
    } while (this.a.mRuntime.a() == null);
    this.a.mRuntime.a().finish();
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool2 = false;
    boolean bool3 = true;
    boolean bool1;
    if ("ShareWidgetAIGifAnimation".equalsIgnoreCase(paramString3)) {
      if ((paramVarArgs == null) || (paramVarArgs.length < 1))
      {
        QLog.e("QzoneWidgetAIJsPlugin", 1, "handleJsRequest, args error!!!");
        bool1 = false;
      }
    }
    for (;;)
    {
      return bool1;
      paramJsBridgeListener = paramVarArgs[0];
      try
      {
        paramJsBridgeListener = new JSONObject(paramJsBridgeListener);
        int i = paramJsBridgeListener.optInt("imageType");
        if ((i == 1) || (i == 0))
        {
          a(paramVarArgs);
          return true;
        }
        bool1 = bool3;
        if (i != 2) {
          continue;
        }
        ThreadManager.executeOnSubThread(new ando(this, paramJsBridgeListener));
        return true;
      }
      catch (Exception paramJsBridgeListener) {}
      if ("WidgetAISkinsChanged".equalsIgnoreCase(paramString3))
      {
        b();
        return true;
      }
      bool1 = bool3;
      if (!"TakeWidgetAIPhoto".equalsIgnoreCase(paramString3)) {
        if ("WidgetAIInfoUpdate".equalsIgnoreCase(paramString3))
        {
          bool1 = bool3;
          if (paramVarArgs == null) {
            continue;
          }
          bool1 = bool3;
          try
          {
            if (paramVarArgs.length > 0)
            {
              bool1 = bool2;
              if (new JSONObject(paramVarArgs[0]).getInt("switch") == 0) {
                bool1 = true;
              }
              RemoteHandleManager.a().a().a(Boolean.valueOf(bool1));
              return true;
            }
          }
          catch (Exception paramJsBridgeListener)
          {
            QLog.e("QzoneWidgetAIJsPlugin", 1, "process widget ai info errror, when jsbridget widgetai info update notify widgetai swtich changed" + QLog.getStackTraceString(paramJsBridgeListener));
            return true;
          }
        }
      }
    }
    if ("SetQuickCommentState".equalsIgnoreCase(paramString3)) {
      try
      {
        RemoteHandleManager.a().a().b(Boolean.valueOf(true));
        return true;
      }
      catch (Exception paramJsBridgeListener)
      {
        QLog.e("QzoneWidgetAIJsPlugin", 1, "process widget ai info errror, when jsbridget widgetai info update notify widgetai quick comment swtich changed" + QLog.getStackTraceString(paramJsBridgeListener));
        return true;
      }
    }
    if ("getWidgetAISharePhoto".equalsIgnoreCase(paramString3)) {
      if (paramVarArgs != null) {
        try
        {
          if (paramVarArgs.length > 0)
          {
            paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
            paramJsBridgeListener.getString("missionKey");
            paramJsBridgeListener.getBoolean("needDivided");
            paramJsBridgeListener.getBoolean("isFirstPiece");
            paramJsBridgeListener.getInt("pieceMaxSize");
            return true;
          }
        }
        catch (Exception paramJsBridgeListener)
        {
          QLog.e("QzoneWidgetAIJsPlugin", 1, "get share photo failed:");
        }
      }
    }
    for (;;)
    {
      return false;
      if ("PetEnterH5Begin".equalsIgnoreCase(paramString3))
      {
        QLog.d("QzoneWidgetAIJsPlugin", 2, "start pet from H5");
        RemoteHandleManager.a().a().p();
      }
    }
    return true;
  }
  
  public void b()
  {
    QLog.d("QzoneWidgetAIJsPlugin", 2, "handleDataChanged");
    RemoteHandleManager.a().a().o();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneWidgetAIJsPlugin
 * JD-Core Version:    0.7.0.1
 */