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
  private float jdField_a_of_type_Float;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new QFlutterFaceLoader.1(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new QFlutterFaceLoader.4(this);
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private MQLruCache<String, Bitmap> jdField_a_of_type_AndroidSupportV4UtilMQLruCache = new MQLruCache(50);
  private List<QFlutterFaceLoader.FaceObserver> jdField_a_of_type_JavaUtilList = new Vector();
  private ConcurrentHashMap<Integer, ArrayList<String>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new QFlutterFaceLoader.2(this);
  private Handler jdField_b_of_type_AndroidOsHandler;
  private MQLruCache<String, String> jdField_b_of_type_AndroidSupportV4UtilMQLruCache = new MQLruCache(100);
  private ConcurrentHashMap<Integer, ArrayList<String>> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public QFlutterFaceLoader(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    c();
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("qflutter_qqface");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_b_of_type_AndroidOsHandler = new Handler();
  }
  
  private Bitmap a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.f();
    }
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  private void a(int paramInt, String paramString)
  {
    ArrayList localArrayList2 = (ArrayList)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null)
    {
      localArrayList1 = new ArrayList();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localArrayList1);
    }
    if (!localArrayList1.contains(paramString)) {
      localArrayList1.add(paramString);
    }
  }
  
  private void a(DecodeRequest paramDecodeRequest, Bitmap paramBitmap, String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_b_of_type_AndroidOsHandler.post(new QFlutterFaceLoader.3(this, paramDecodeRequest, paramBitmap, paramString));
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
      ((Intent)localObject).setPackage(this.jdField_a_of_type_AndroidContentContext.getPackageName());
      ((Intent)localObject).putExtra("faceType", paramInt);
      ((Intent)localObject).putStringArrayListExtra("uinList", paramArrayList);
      this.jdField_a_of_type_AndroidContentContext.sendBroadcast((Intent)localObject, "com.tencent.qqhead.permission.getheadresp");
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
        String str = (String)this.jdField_b_of_type_AndroidSupportV4UtilMQLruCache.get(localDecodeRequest.c);
        Bitmap localBitmap = DecodeUtils.a(str, localDecodeRequest.jdField_b_of_type_Int, this.jdField_a_of_type_Float);
        if (localBitmap != null)
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("decodeFaceBitmap addCache ");
            localStringBuilder.append(localDecodeRequest.jdField_b_of_type_JavaLangString);
            QLog.d("QFlutter.qqface", 2, localStringBuilder.toString());
          }
          this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(localDecodeRequest.jdField_b_of_type_JavaLangString, localBitmap);
          a(localDecodeRequest, localBitmap, str);
        }
      }
    }
  }
  
  private boolean a(DecodeRequest paramDecodeRequest)
  {
    List localList = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramDecodeRequest.jdField_a_of_type_Int));
    if ((localList != null) && (!localList.isEmpty())) {
      return localList.contains(paramDecodeRequest.jdField_a_of_type_JavaLangString);
    }
    return false;
  }
  
  private void b(int paramInt, String paramString)
  {
    ArrayList localArrayList2 = (ArrayList)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null)
    {
      localArrayList1 = new ArrayList();
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localArrayList1);
    }
    if (!localArrayList1.contains(paramString)) {
      localArrayList1.add(paramString);
    }
  }
  
  private boolean b(DecodeRequest paramDecodeRequest)
  {
    List localList = (List)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramDecodeRequest.jdField_a_of_type_Int));
    if ((localList != null) && (!localList.isEmpty())) {
      return localList.contains(paramDecodeRequest.jdField_a_of_type_JavaLangString);
    }
    return false;
  }
  
  private void c()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.qqhead.getheadresp");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.qqhead.permission.getheadresp", null);
    localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.qqhead.changed");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private void c(int paramInt, String paramString)
  {
    ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if ((localArrayList != null) && (!localArrayList.isEmpty())) {
      localArrayList.remove(paramString);
    }
  }
  
  private void d()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
  }
  
  private void d(int paramInt, String paramString)
  {
    ArrayList localArrayList = (ArrayList)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if ((localArrayList != null) && (!localArrayList.isEmpty())) {
      localArrayList.remove(paramString);
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
    Object localObject1 = paramDecodeRequest.jdField_b_of_type_JavaLangString;
    String str = paramDecodeRequest.c;
    Object localObject2 = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(localObject1);
    str = (String)this.jdField_b_of_type_AndroidSupportV4UtilMQLruCache.get(str);
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
    if (FileUtil.b(str))
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
      localObject2 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0);
      ((Message)localObject2).obj = localObject1;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
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
      if ((!a(paramDecodeRequest)) || (!b(paramDecodeRequest)))
      {
        a(paramDecodeRequest.jdField_a_of_type_Int, paramDecodeRequest.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 50L);
      }
    }
    return new Pair(a(paramDecodeRequest.jdField_b_of_type_Int), Boolean.valueOf(true));
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.evictAll();
    this.jdField_b_of_type_AndroidSupportV4UtilMQLruCache.evictAll();
  }
  
  public void a(QFlutterFaceLoader.FaceObserver paramFaceObserver)
  {
    if (paramFaceObserver == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramFaceObserver)) {
        this.jdField_a_of_type_JavaUtilList.add(paramFaceObserver);
      }
      return;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
    d();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandlerThread.quit();
    a();
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.qqface", 2, "onDestroy");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.qqface.QFlutterFaceLoader
 * JD-Core Version:    0.7.0.1
 */