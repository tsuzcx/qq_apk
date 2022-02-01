package com.tencent.richmediabrowser.download;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.text.TextUtils;
import android.widget.ImageView.ScaleType;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.tencent.richmediabrowser.core.RichMediaBrowserManager;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import org.json.JSONObject;

public class HttpDownloadManager
{
  private static final String TAG = "HttpDownloadManager";
  private ConcurrentHashMap<String, IImageDownloadListener> imageListenerMap = new ConcurrentHashMap();
  RequestQueue mQueue;
  
  public static HttpDownloadManager getInstance()
  {
    return HttpDownloadManager.SingletonHolder.access$100();
  }
  
  public void addImageDownloadListener(String paramString, IImageDownloadListener paramIImageDownloadListener)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!this.imageListenerMap.contains(paramString))) {
      this.imageListenerMap.put(paramString, paramIImageDownloadListener);
    }
  }
  
  public void clean()
  {
    this.imageListenerMap.clear();
  }
  
  public void downloadImage(String paramString, IImageDownloadListener paramIImageDownloadListener)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (paramIImageDownloadListener != null) {
        paramIImageDownloadListener.onError(new DownloadError("url is null"));
      }
      return;
    }
    paramString = new ImageRequest(paramString, new HttpDownloadManager.5(this, paramIImageDownloadListener, paramString), 0, 0, ImageView.ScaleType.CENTER, Bitmap.Config.ARGB_8888, new HttpDownloadManager.6(this, paramIImageDownloadListener));
    getRequestQueue().add(paramString);
  }
  
  public Bitmap downloadImageSync(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      RequestFuture localRequestFuture = RequestFuture.newFuture();
      paramString = new ImageRequest(paramString, localRequestFuture, 0, 0, ImageView.ScaleType.CENTER, Bitmap.Config.ARGB_8888, localRequestFuture);
      getRequestQueue().add(paramString);
      paramString = (Bitmap)localRequestFuture.get();
      return paramString;
    }
    catch (InterruptedException paramString)
    {
      BrowserLogHelper.getInstance().getGalleryLog().e("HttpDownloadManager", 1, "downloadImage error.");
      return null;
    }
    catch (ExecutionException paramString)
    {
      for (;;)
      {
        BrowserLogHelper.getInstance().getGalleryLog().e("HttpDownloadManager", 1, "downloadImage error.");
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        BrowserLogHelper.getInstance().getGalleryLog().e("HttpDownloadManager", 1, "downloadImage error.");
      }
    }
  }
  
  public void downloadJson(String paramString, JSONObject paramJSONObject, IJsonDownloadListener paramIJsonDownloadListener)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (paramIJsonDownloadListener != null) {
        paramIJsonDownloadListener.onError(new DownloadError("url is null"));
      }
      return;
    }
    paramString = new JsonObjectRequest(paramString, paramJSONObject, new HttpDownloadManager.3(this, paramIJsonDownloadListener), new HttpDownloadManager.4(this, paramIJsonDownloadListener));
    getRequestQueue().add(paramString);
  }
  
  public void downloadString(String paramString, IStringDownloadListener paramIStringDownloadListener)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (paramIStringDownloadListener != null) {
        paramIStringDownloadListener.onError(new DownloadError("url is null"));
      }
      return;
    }
    paramString = new StringRequest(paramString, new HttpDownloadManager.1(this, paramIStringDownloadListener), new HttpDownloadManager.2(this, paramIStringDownloadListener));
    getRequestQueue().add(paramString);
  }
  
  public IImageDownloadListener getImageDownloadListener(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (IImageDownloadListener)this.imageListenerMap.get(paramString);
  }
  
  public RequestQueue getRequestQueue()
  {
    if (this.mQueue == null) {
      this.mQueue = Volley.newRequestQueue(RichMediaBrowserManager.getInstance().getApplicationContext());
    }
    return this.mQueue;
  }
  
  public void removeImageDownloadListener(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.imageListenerMap.contains(paramString))) {
      this.imageListenerMap.remove(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.richmediabrowser.download.HttpDownloadManager
 * JD-Core Version:    0.7.0.1
 */