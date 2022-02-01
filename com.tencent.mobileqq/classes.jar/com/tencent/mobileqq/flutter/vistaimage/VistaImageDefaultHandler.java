package com.tencent.mobileqq.flutter.vistaimage;

import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.TextUtils;
import com.qflutter.vistaimage.IRenderer;
import com.qflutter.vistaimage.IVistaImage;
import com.qflutter.vistaimage.IVistaImage.LoadBitmapCallback;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class VistaImageDefaultHandler
  implements IVistaImage
{
  private Map<String, URLDrawable> a = new ConcurrentHashMap();
  
  private void a(String paramString, int paramInt1, int paramInt2, IVistaImage.LoadBitmapCallback paramLoadBitmapCallback)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramInt1;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramInt2;
    localObject = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
    this.a.put(paramString, localObject);
    ((URLDrawable)localObject).setURLDrawableListener(new VistaImageDefaultHandler.1(this, paramLoadBitmapCallback, paramString));
    ((URLDrawable)localObject).run();
  }
  
  private void a(String paramString, IVistaImage.LoadBitmapCallback paramLoadBitmapCallback)
  {
    Observable.just(paramString).subscribeOn(Schedulers.io()).map(new VistaImageDefaultHandler.3(this, paramString)).observeOn(AndroidSchedulers.mainThread()).subscribe(new VistaImageDefaultHandler.2(this, paramLoadBitmapCallback, paramString));
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    int i = 0;
    while (i < paramString.length())
    {
      if (!Character.isDigit(paramString.charAt(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private void b(String paramString, IVistaImage.LoadBitmapCallback paramLoadBitmapCallback)
  {
    if (paramLoadBitmapCallback == null) {
      QLog.w("VistaImageDefaultHandler", 1, "[onLoadAvatar] invalid callback");
    }
    Object localObject = Uri.parse(paramString);
    String str1 = ((Uri)localObject).getHost();
    localObject = ((Uri)localObject).getPathSegments();
    String str2 = (String)((List)localObject).get(0);
    if (((List)localObject).size() > 1) {
      localObject = (String)((List)localObject).get(1);
    } else {
      localObject = "0";
    }
    if ((a(str1)) && (a(str2)) && (a((String)localObject)))
    {
      localObject = new QQAvatarRenderer(str1, Integer.parseInt(str2), Integer.parseInt((String)localObject));
      paramLoadBitmapCallback.onLoaded(paramString, new BitmapDrawable(BaseApplicationImpl.getContext().getResources(), ((QQAvatarRenderer)localObject).a()), false, (IRenderer)localObject);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("invalid parameters, uin=");
    localStringBuilder.append(str1);
    localStringBuilder.append(", type=");
    localStringBuilder.append(str2);
    localStringBuilder.append(", shape=");
    localStringBuilder.append((String)localObject);
    paramLoadBitmapCallback.onFailed(paramString, -4, localStringBuilder.toString());
  }
  
  public void clear()
  {
    QLog.d("VistaImageDefaultHandler", 1, "[clear]");
    this.a.clear();
  }
  
  public void loadBitmap(String paramString, int paramInt1, int paramInt2, int paramInt3, IVistaImage.LoadBitmapCallback paramLoadBitmapCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[loadBitmap] uriString=");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("VistaImageDefaultHandler", 2, ((StringBuilder)localObject).toString());
    localObject = Uri.parse(paramString).getScheme();
    if ((!"http".equals(localObject)) && (!"https".equals(localObject)))
    {
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        a(paramString, paramLoadBitmapCallback);
        return;
      }
      if ("avatar".equals(localObject))
      {
        b(paramString, paramLoadBitmapCallback);
        return;
      }
      QLog.d("VistaImageDefaultHandler", 1, "[loadBitmap] scheme not handled yet");
      paramLoadBitmapCallback.onFailed(paramString, -4, "not handled scheme");
      return;
    }
    a(paramString, paramInt1, paramInt2, paramLoadBitmapCallback);
  }
  
  public void releaseBitmap(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.remove(paramString);
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("[releaseBitmap] urlDrawableMap size=");
      paramString.append(this.a.size());
      QLog.d("VistaImageDefaultHandler", 2, paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.vistaimage.VistaImageDefaultHandler
 * JD-Core Version:    0.7.0.1
 */