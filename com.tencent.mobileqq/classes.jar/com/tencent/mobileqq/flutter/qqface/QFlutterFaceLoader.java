package com.tencent.mobileqq.flutter.qqface;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class QFlutterFaceLoader
{
  private Context a = BaseApplicationImpl.getContext();
  private float b = this.a.getResources().getDisplayMetrics().density;
  private List<QFlutterFaceLoader.FaceObserver> c = new Vector();
  private HandlerThread d;
  private Handler e;
  private Handler f;
  private Bitmap g;
  private MQLruCache<String, Bitmap> h = new MQLruCache(50);
  private MQLruCache<String, String> i = new MQLruCache(100);
  private ConcurrentHashMap<Integer, ArrayList<String>> j = new ConcurrentHashMap();
  private ConcurrentHashMap<Integer, ArrayList<String>> k = new ConcurrentHashMap();
  private BroadcastReceiver l = new QFlutterFaceLoader.1(this);
  private BroadcastReceiver m = new QFlutterFaceLoader.2(this);
  private Handler.Callback n = new QFlutterFaceLoader.4(this);
  
  private QFlutterFaceLoader()
  {
    d();
    this.d = new HandlerThread("qflutter_qqface");
    this.d.start();
    this.e = new Handler(this.d.getLooper(), this.n);
    this.f = new Handler();
  }
  
  private Bitmap a(int paramInt)
  {
    if (this.g == null) {
      this.g = ImageUtil.k();
    }
    return this.g;
  }
  
  public static QFlutterFaceLoader a()
  {
    return QFlutterFaceLoader.SingleHolder.a;
  }
  
  private void a(int paramInt, String paramString)
  {
    ArrayList localArrayList2 = (ArrayList)this.j.get(Integer.valueOf(paramInt));
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null)
    {
      localArrayList1 = new ArrayList();
      this.j.put(Integer.valueOf(paramInt), localArrayList1);
    }
    if (!localArrayList1.contains(paramString)) {
      localArrayList1.add(paramString);
    }
  }
  
  private void a(DecodeRequest paramDecodeRequest, Bitmap paramBitmap, String paramString)
  {
    synchronized (this.c)
    {
      this.f.post(new QFlutterFaceLoader.3(this, paramDecodeRequest, paramBitmap, paramString));
      return;
    }
  }
  
  private void a(ArrayList<String> paramArrayList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.qqface", 2, String.format("sendFaceRequest, uinList: %s, faceType: %s", new Object[] { paramArrayList, Integer.valueOf(paramInt) }));
    }
    if (paramArrayList != null)
    {
      if (paramArrayList.isEmpty()) {
        return;
      }
      Object localObject = paramArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        c(paramInt, str);
        b(paramInt, str);
      }
      localObject = new Intent("com.tencent.qqhead.getheadreq");
      ((Intent)localObject).setPackage(this.a.getPackageName());
      ((Intent)localObject).putExtra("faceType", paramInt);
      ((Intent)localObject).putStringArrayListExtra("uinList", paramArrayList);
      this.a.sendBroadcast((Intent)localObject, "com.tencent.qqhead.permission.getheadresp");
    }
  }
  
  private void a(List<DecodeRequest> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.qqface", 2, "decodeFaceBitmap");
    }
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DecodeRequest localDecodeRequest = (DecodeRequest)paramList.next();
        String str = (String)this.i.get(localDecodeRequest.e);
        Bitmap localBitmap = DecodeUtils.a(str, localDecodeRequest.c, this.b);
        if (localBitmap != null)
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("decodeFaceBitmap addCache ");
            localStringBuilder.append(localDecodeRequest.d);
            QLog.d("QFlutter.qqface", 2, localStringBuilder.toString());
          }
          this.h.put(localDecodeRequest.d, localBitmap);
          a(localDecodeRequest, localBitmap, str);
        }
      }
    }
  }
  
  private void b(int paramInt, String paramString)
  {
    ArrayList localArrayList2 = (ArrayList)this.k.get(Integer.valueOf(paramInt));
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null)
    {
      localArrayList1 = new ArrayList();
      this.k.put(Integer.valueOf(paramInt), localArrayList1);
    }
    if (!localArrayList1.contains(paramString)) {
      localArrayList1.add(paramString);
    }
  }
  
  private boolean b(DecodeRequest paramDecodeRequest)
  {
    List localList = (List)this.j.get(Integer.valueOf(paramDecodeRequest.b));
    if ((localList != null) && (!localList.isEmpty())) {
      return localList.contains(paramDecodeRequest.a);
    }
    return false;
  }
  
  private void c(int paramInt, String paramString)
  {
    ArrayList localArrayList = (ArrayList)this.j.get(Integer.valueOf(paramInt));
    if ((localArrayList != null) && (!localArrayList.isEmpty())) {
      localArrayList.remove(paramString);
    }
  }
  
  private boolean c(DecodeRequest paramDecodeRequest)
  {
    List localList = (List)this.k.get(Integer.valueOf(paramDecodeRequest.b));
    if ((localList != null) && (!localList.isEmpty())) {
      return localList.contains(paramDecodeRequest.a);
    }
    return false;
  }
  
  private void d()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.qqhead.getheadresp");
    this.a.registerReceiver(this.l, localIntentFilter, "com.tencent.qqhead.permission.getheadresp", null);
    localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.qqhead.changed");
    this.a.registerReceiver(this.m, localIntentFilter);
  }
  
  private void d(int paramInt, String paramString)
  {
    ArrayList localArrayList = (ArrayList)this.k.get(Integer.valueOf(paramInt));
    if ((localArrayList != null) && (!localArrayList.isEmpty())) {
      localArrayList.remove(paramString);
    }
  }
  
  private void e()
  {
    synchronized (this.c)
    {
      this.c.clear();
      return;
    }
  }
  
  public Pair<Bitmap, Boolean> a(DecodeRequest paramDecodeRequest)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getBitmap: ");
      ((StringBuilder)localObject1).append(paramDecodeRequest);
      QLog.d("QFlutter.qqface", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = paramDecodeRequest.d;
    String str = paramDecodeRequest.e;
    Object localObject2 = (Bitmap)this.h.get(localObject1);
    str = (String)this.i.get(str);
    if (localObject2 != null)
    {
      if (QLog.isColorLevel())
      {
        paramDecodeRequest = new StringBuilder();
        paramDecodeRequest.append("faceKey: ");
        paramDecodeRequest.append((String)localObject1);
        paramDecodeRequest.append(" use bitmap cache");
        QLog.d("QFlutter.qqface", 2, paramDecodeRequest.toString());
      }
      return new Pair(localObject2, Boolean.valueOf(false));
    }
    if (FileUtil.d(str))
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("faceKey: ");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" use path cache");
        QLog.d("QFlutter.qqface", 2, ((StringBuilder)localObject2).toString());
      }
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(paramDecodeRequest);
      localObject2 = this.e.obtainMessage(0);
      ((Message)localObject2).obj = localObject1;
      this.e.sendMessage((Message)localObject2);
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("faceKey: ");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" request");
        QLog.d("QFlutter.qqface", 2, ((StringBuilder)localObject2).toString());
      }
      if ((!b(paramDecodeRequest)) || (!c(paramDecodeRequest)))
      {
        a(paramDecodeRequest.b, paramDecodeRequest.a);
        this.e.removeMessages(1);
        this.e.sendEmptyMessageDelayed(1, 50L);
      }
    }
    return new Pair(a(paramDecodeRequest.c), Boolean.valueOf(true));
  }
  
  public void a(QFlutterFaceLoader.FaceObserver paramFaceObserver)
  {
    if (paramFaceObserver == null) {
      return;
    }
    synchronized (this.c)
    {
      if (!this.c.contains(paramFaceObserver)) {
        this.c.add(paramFaceObserver);
      }
      return;
    }
  }
  
  public void b()
  {
    this.h.evictAll();
    this.i.evictAll();
  }
  
  public void b(QFlutterFaceLoader.FaceObserver paramFaceObserver)
  {
    synchronized (this.c)
    {
      this.c.remove(paramFaceObserver);
      return;
    }
  }
  
  public void c()
  {
    this.a.unregisterReceiver(this.l);
    this.a.unregisterReceiver(this.m);
    e();
    this.e.removeCallbacksAndMessages(null);
    this.d.quit();
    b();
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.qqface", 2, "onDestroy");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.qqface.QFlutterFaceLoader
 * JD-Core Version:    0.7.0.1
 */