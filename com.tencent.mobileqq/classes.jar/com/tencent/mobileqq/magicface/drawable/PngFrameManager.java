package com.tencent.mobileqq.magicface.drawable;

import aedh;
import aedj;
import aedk;
import aedm;
import aedp;
import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.Holder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class PngFrameManager
  implements IMessageHandler, Manager
{
  public Handler a;
  public QQAppInterface a;
  public PngFrameUtil a;
  public DownloaderInterface a;
  public HashMap a;
  ConcurrentHashMap a;
  
  @SuppressLint({"UseSparseArrays"})
  public PngFrameManager(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "PngFrameManager 【Constructor】  ");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = a(this);
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameUtil = new PngFrameUtil();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface = ((DownloaderFactory)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46)).a(1);
  }
  
  public static Handler a(IMessageHandler paramIMessageHandler)
  {
    return new aedp(paramIMessageHandler);
  }
  
  PngFrameDrawable a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "func getPngFrameDrawable begins,epId:" + paramString + ",pos:" + paramInt + ",showProcess:" + paramBoolean);
    }
    String str = "PngFrameManager_" + paramString + "_" + paramInt;
    Object localObject = a(paramString);
    if (localObject == null)
    {
      paramString = null;
      return paramString;
    }
    paramString = BaseApplicationImpl.sImageCache.get(str);
    if ((paramString instanceof PngFrameDrawable)) {}
    for (paramString = (PngFrameDrawable)paramString;; paramString = null)
    {
      if ((paramString == null) || (paramBoolean) || (!paramString.a()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PngFrameManager", 2, "func getPngFrameDrawable, 【NOT find】  drawable in the map.");
        }
        ((PngPlayParam)localObject).jdField_a_of_type_Boolean = paramBoolean;
        localObject = new PngFrameDrawable((PngPlayParam)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources());
        BaseApplicationImpl.sImageCache.put(str, localObject);
        ((PngFrameDrawable)localObject).a(paramInt);
      }
      for (;;)
      {
        paramString = (String)localObject;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("PngFrameManager", 2, "func getPngFrameDrawable ends");
        return localObject;
        localObject = paramString;
        if (QLog.isColorLevel())
        {
          QLog.d("PngFrameManager", 2, "func getPngFrameDrawable, drawable exists in map,pos:" + paramInt);
          localObject = paramString;
        }
      }
    }
  }
  
  public PngPlayParam a(String paramString)
  {
    Object localObject;
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null)) {
      localObject = null;
    }
    PngPlayParam localPngPlayParam;
    do
    {
      return localObject;
      localPngPlayParam = (PngPlayParam)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      localObject = localPngPlayParam;
    } while (localPngPlayParam != null);
    return b(paramString);
  }
  
  public void a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
        paramMessage = (PngFrameManager.RandomDrawableParam)paramMessage.obj;
        paramMessage.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_e_of_type_Int = paramMessage.jdField_a_of_type_Int;
        if (paramMessage.jdField_a_of_type_Int == 0)
        {
          a(paramMessage);
          return;
        }
      } while (paramMessage.jdField_a_of_type_Int != 1);
      c(paramMessage);
      return;
      paramMessage = (PngFrameManager.RandomDrawableParam)paramMessage.obj;
      paramMessage.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      f(paramMessage);
      return;
      paramMessage = (PngFrameManager.RandomDrawableParam)paramMessage.obj;
      paramMessage.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramMessage.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130843960);
      return;
      paramMessage = (PngFrameManager.RandomDrawableParam)paramMessage.obj;
    } while (paramMessage.jdField_a_of_type_Long != paramMessage.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_Long);
    paramMessage.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    paramMessage.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramMessage.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_e_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)paramMessage.jdField_a_of_type_JavaLangObject);
  }
  
  @SuppressLint({"InlinedApi"})
  void a(MarketFaceItemBuilder.Holder paramHolder, boolean paramBoolean)
  {
    int j = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
    int i = (j * 200 + 160) / 320;
    j = (200 * j + 160) / 320;
    if (paramBoolean)
    {
      paramHolder.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams(new FrameLayout.LayoutParams(i, j));
      return;
    }
    paramHolder = (RelativeLayout.LayoutParams)paramHolder.jdField_e_of_type_AndroidWidgetImageView.getLayoutParams();
    paramHolder.width = i;
    paramHolder.height = j;
  }
  
  void a(PngFrameManager.RandomDrawableParam paramRandomDrawableParam)
  {
    if ((paramRandomDrawableParam != null) && (paramRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder != null) && (paramRandomDrawableParam.jdField_a_of_type_Long == paramRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_Long) && (paramRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$IMagicCallback != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PngFrameManager", 2, "func onTypeGif, 【rsyType is GIF, use the OLD way to show.】");
      }
      paramRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$IMagicCallback.a(true);
    }
  }
  
  public void a(String paramString, MarketFaceItemBuilder.Holder paramHolder, long paramLong, boolean paramBoolean1, boolean paramBoolean2, PngFrameManager.IMagicCallback paramIMagicCallback)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramHolder == null)) {
      if (paramIMagicCallback != null) {
        paramIMagicCallback.a(true);
      }
    }
    for (;;)
    {
      return;
      a(paramHolder, paramBoolean2);
      PngFrameManager.RandomDrawableParam localRandomDrawableParam = new PngFrameManager.RandomDrawableParam(this);
      localRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$IMagicCallback = paramIMagicCallback;
      localRandomDrawableParam.jdField_a_of_type_JavaLangString = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId;
      localRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder = paramHolder;
      localRandomDrawableParam.jdField_a_of_type_Long = paramLong;
      localRandomDrawableParam.jdField_a_of_type_Boolean = paramBoolean1;
      localRandomDrawableParam.b = PngFrameUtil.b(paramString);
      if (localRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_AndroidWidgetProgressBar == null) {
        localRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_AndroidWidgetProgressBar = new ProgressBar(BaseApplicationImpl.getContext());
      }
      if (localRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_AndroidWidgetImageView == null) {
        localRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_AndroidWidgetImageView = new ImageView(BaseApplicationImpl.getContext());
      }
      int i = PngFrameUtil.a(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("PngFrameManager", 2, "func setMagicDrawable, 【rscType】:" + i + ",【randomValue】:" + localRandomDrawableParam.b + ",【showProcess】:" + paramBoolean1 + ",tag:" + paramLong);
      }
      paramHolder.jdField_e_of_type_Int = i;
      switch (i)
      {
      }
      while ((localRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_a_of_type_AndroidOsHandler != null))
      {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new aedh(this, localRandomDrawableParam), 1000L);
        return;
        a(localRandomDrawableParam);
        continue;
        c(localRandomDrawableParam);
        continue;
        b(localRandomDrawableParam);
      }
    }
  }
  
  /* Error */
  public boolean a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 59	com/tencent/mobileqq/magicface/drawable/PngFrameManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   6: ifnonnull +14 -> 20
    //   9: aload_0
    //   10: new 56	java/util/HashMap
    //   13: dup
    //   14: invokespecial 57	java/util/HashMap:<init>	()V
    //   17: putfield 59	com/tencent/mobileqq/magicface/drawable/PngFrameManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   20: aload_0
    //   21: getfield 59	com/tencent/mobileqq/magicface/drawable/PngFrameManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   24: lload_1
    //   25: invokestatic 353	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   28: invokevirtual 354	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   31: checkcast 356	java/lang/Boolean
    //   34: ifnonnull +36 -> 70
    //   37: aload_0
    //   38: getfield 44	com/tencent/mobileqq/magicface/drawable/PngFrameManager:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   41: ifnull +29 -> 70
    //   44: aload_0
    //   45: getfield 44	com/tencent/mobileqq/magicface/drawable/PngFrameManager:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   48: new 358	aedo
    //   51: dup
    //   52: aload_0
    //   53: lload_1
    //   54: invokespecial 361	aedo:<init>	(Lcom/tencent/mobileqq/magicface/drawable/PngFrameManager;J)V
    //   57: ldc2_w 362
    //   60: invokevirtual 344	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   63: pop
    //   64: iconst_1
    //   65: istore_3
    //   66: aload_0
    //   67: monitorexit
    //   68: iload_3
    //   69: ireturn
    //   70: iconst_0
    //   71: istore_3
    //   72: goto -6 -> 66
    //   75: astore 4
    //   77: aload_0
    //   78: monitorexit
    //   79: aload 4
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	PngFrameManager
    //   0	82	1	paramLong	long
    //   65	7	3	bool	boolean
    //   75	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	75	finally
    //   20	64	75	finally
  }
  
  public PngPlayParam b(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    PngPlayParam localPngPlayParam;
    do
    {
      return localObject;
      localPngPlayParam = this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameUtil.a(paramString);
      localObject = localPngPlayParam;
    } while (localPngPlayParam == null);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localPngPlayParam);
    return localPngPlayParam;
  }
  
  void b(PngFrameManager.RandomDrawableParam paramRandomDrawableParam)
  {
    paramRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130843959);
    ThreadManager.post(new aedj(this, paramRandomDrawableParam), 5, null, true);
  }
  
  void c(PngFrameManager.RandomDrawableParam paramRandomDrawableParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "func onTypePngZip begins, param:" + paramRandomDrawableParam);
    }
    if (new File(EmoticonUtils.z.replace("[epId]", paramRandomDrawableParam.jdField_a_of_type_JavaLangString)).exists())
    {
      f(paramRandomDrawableParam);
      return;
    }
    int i = NetworkUtil.a(BaseApplication.getContext());
    if ((i != 1) && (i != 3) && (i != 4) && (i != 0))
    {
      d(paramRandomDrawableParam);
      return;
    }
    paramRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130843959);
    e(paramRandomDrawableParam);
  }
  
  void d(PngFrameManager.RandomDrawableParam paramRandomDrawableParam)
  {
    String str = EmoticonUtils.q.replace("[epId]", paramRandomDrawableParam.jdField_a_of_type_JavaLangString).replace("[eId]", paramRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.eId);
    Bitmap localBitmap = (Bitmap)BaseApplicationImpl.sImageCache.get(str);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PngFrameManager", 2, "func showAIOPreview, 【aio preview】, exist in Cache.");
      }
      paramRandomDrawableParam.jdField_a_of_type_JavaLangObject = localBitmap;
      try
      {
        if (this.jdField_a_of_type_AndroidOsHandler != null) {
          this.jdField_a_of_type_AndroidOsHandler.obtainMessage(227, paramRandomDrawableParam).sendToTarget();
        }
        return;
      }
      finally {}
    }
    paramRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130843959);
    ThreadManager.post(new aedk(this, str, paramRandomDrawableParam), 5, null, true);
  }
  
  public void e(PngFrameManager.RandomDrawableParam paramRandomDrawableParam)
  {
    ThreadManager.post(new aedm(this, paramRandomDrawableParam), 5, null, true);
  }
  
  void f(PngFrameManager.RandomDrawableParam paramRandomDrawableParam)
  {
    Object localObject = a(paramRandomDrawableParam.jdField_a_of_type_JavaLangString);
    if ((localObject == null) || (!((PngPlayParam)localObject).a())) {}
    do
    {
      return;
      localObject = a(paramRandomDrawableParam.jdField_a_of_type_JavaLangString, paramRandomDrawableParam.b, paramRandomDrawableParam.jdField_a_of_type_Boolean);
      if ((paramRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder != null) && (paramRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_Long == paramRandomDrawableParam.jdField_a_of_type_Long)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PngFrameManager", 2, "func showDrawable ends, 【holder not Exists!】");
    return;
    if (localObject != null)
    {
      paramRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
    }
    try
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.obtainMessage(226, paramRandomDrawableParam).sendToTarget();
      }
      return;
    }
    finally {}
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "PngFrameManager 【onDestroy】  ");
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_JavaUtilHashMap = null;
    }
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.drawable.PngFrameManager
 * JD-Core Version:    0.7.0.1
 */