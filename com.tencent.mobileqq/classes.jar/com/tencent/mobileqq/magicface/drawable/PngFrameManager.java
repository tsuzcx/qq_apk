package com.tencent.mobileqq.magicface.drawable;

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
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.EmotionPanelConstans;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
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
  Handler jdField_a_of_type_AndroidOsHandler;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  PngFrameUtil jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameUtil;
  DownloaderInterface jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface;
  HashMap<Long, Boolean> jdField_a_of_type_JavaUtilHashMap;
  ConcurrentHashMap<String, PngPlayParam> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  
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
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface = ((DownloaderFactory)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
  }
  
  public static Handler a(IMessageHandler paramIMessageHandler)
  {
    return new PngFrameManager.InnerHandler(paramIMessageHandler);
  }
  
  PngFrameDrawable a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("func getPngFrameDrawable begins,epId:");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(",pos:");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(",showProcess:");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("PngFrameManager", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("PngFrameManager_");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(paramInt);
    String str = ((StringBuilder)localObject1).toString();
    localObject1 = a(paramString);
    paramString = null;
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = GlobalImageCache.a.get(str);
    if ((localObject2 instanceof PngFrameDrawable)) {
      paramString = (PngFrameDrawable)localObject2;
    }
    if ((paramString != null) && (!paramBoolean) && (paramString.a()))
    {
      localObject1 = paramString;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("func getPngFrameDrawable, drawable exists in map,pos:");
        ((StringBuilder)localObject1).append(paramInt);
        QLog.d("PngFrameManager", 2, ((StringBuilder)localObject1).toString());
        localObject1 = paramString;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("PngFrameManager", 2, "func getPngFrameDrawable, 【NOT find】  drawable in the map.");
      }
      ((PngPlayParam)localObject1).jdField_a_of_type_Boolean = paramBoolean;
      localObject1 = new PngFrameDrawable((PngPlayParam)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources());
      GlobalImageCache.a.put(str, localObject1);
      ((PngFrameDrawable)localObject1).a(paramInt);
    }
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "func getPngFrameDrawable ends");
    }
    return localObject1;
  }
  
  public PngPlayParam a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
      if (localObject != null)
      {
        localObject = (PngPlayParam)((ConcurrentHashMap)localObject).get(paramString);
        if (localObject != null) {
          return localObject;
        }
        return b(paramString);
      }
    }
    return null;
  }
  
  @SuppressLint({"InlinedApi"})
  void a(MarketFaceItemBuilder.Holder paramHolder, boolean paramBoolean)
  {
    int j = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
    int i = (200 * j + 160) / 320;
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
    if ((!TextUtils.isEmpty(paramString)) && (paramHolder != null))
    {
      a(paramHolder, paramBoolean2);
      PngFrameManager.RandomDrawableParam localRandomDrawableParam = new PngFrameManager.RandomDrawableParam(this);
      localRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$IMagicCallback = paramIMagicCallback;
      localRandomDrawableParam.jdField_a_of_type_JavaLangString = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId;
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
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("func setMagicDrawable, 【rscType】:");
        paramString.append(i);
        paramString.append(",【randomValue】:");
        paramString.append(localRandomDrawableParam.b);
        paramString.append(",【showProcess】:");
        paramString.append(paramBoolean1);
        paramString.append(",tag:");
        paramString.append(paramLong);
        QLog.d("PngFrameManager", 2, paramString.toString());
      }
      paramHolder.jdField_e_of_type_Int = i;
      if (i != -1)
      {
        if (i != 0)
        {
          if (i == 1) {
            c(localRandomDrawableParam);
          }
        }
        else {
          a(localRandomDrawableParam);
        }
      }
      else {
        b(localRandomDrawableParam);
      }
      if (localRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
        return;
      }
      paramString = this.jdField_a_of_type_AndroidOsHandler;
      if (paramString == null) {
        return;
      }
      paramString.postDelayed(new PngFrameManager.1(this, localRandomDrawableParam), 1000L);
      return;
    }
    if (paramIMagicCallback != null) {
      paramIMagicCallback.a(true);
    }
  }
  
  public boolean a(long paramLong)
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilHashMap == null) {
        this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      }
      if (((Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong)) == null) && (this.jdField_a_of_type_AndroidOsHandler != null))
      {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new PngFrameManager.5(this, paramLong), 500L);
        return true;
      }
      return false;
    }
    finally {}
  }
  
  public PngPlayParam b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    PngPlayParam localPngPlayParam = this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameUtil.a(paramString);
    if (localPngPlayParam != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localPngPlayParam);
    }
    return localPngPlayParam;
  }
  
  void b(PngFrameManager.RandomDrawableParam paramRandomDrawableParam)
  {
    paramRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130847348);
    ThreadManager.post(new PngFrameManager.2(this, paramRandomDrawableParam), 5, null, true);
  }
  
  void c(PngFrameManager.RandomDrawableParam paramRandomDrawableParam)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("func onTypePngZip begins, param:");
      localStringBuilder.append(paramRandomDrawableParam);
      QLog.d("PngFrameManager", 2, localStringBuilder.toString());
    }
    if (new File(EmotionPanelConstans.pngFramePath.replace("[epId]", paramRandomDrawableParam.jdField_a_of_type_JavaLangString)).exists())
    {
      f(paramRandomDrawableParam);
      return;
    }
    int i = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    if ((i != 1) && (i != 3) && (i != 4) && (i != 0))
    {
      d(paramRandomDrawableParam);
      return;
    }
    paramRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130847348);
    e(paramRandomDrawableParam);
  }
  
  void d(PngFrameManager.RandomDrawableParam paramRandomDrawableParam)
  {
    String str = EmotionPanelConstans.emoticonAIOPreviewPath.replace("[epId]", paramRandomDrawableParam.jdField_a_of_type_JavaLangString).replace("[eId]", paramRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().eId);
    Bitmap localBitmap = (Bitmap)GlobalImageCache.a.get(str);
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
    paramRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130847348);
    ThreadManager.post(new PngFrameManager.3(this, str, paramRandomDrawableParam), 5, null, true);
  }
  
  void e(PngFrameManager.RandomDrawableParam paramRandomDrawableParam)
  {
    ThreadManager.post(new PngFrameManager.4(this, paramRandomDrawableParam), 5, null, true);
  }
  
  void f(PngFrameManager.RandomDrawableParam paramRandomDrawableParam)
  {
    Object localObject = a(paramRandomDrawableParam.jdField_a_of_type_JavaLangString);
    if (localObject != null)
    {
      if (!((PngPlayParam)localObject).a()) {
        return;
      }
      localObject = a(paramRandomDrawableParam.jdField_a_of_type_JavaLangString, paramRandomDrawableParam.b, paramRandomDrawableParam.jdField_a_of_type_Boolean);
      if ((paramRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder != null) && (paramRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_Long == paramRandomDrawableParam.jdField_a_of_type_Long))
      {
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
      if (QLog.isColorLevel()) {
        QLog.d("PngFrameManager", 2, "func showDrawable ends, 【holder not Exists!】");
      }
    }
  }
  
  public void handleMsg(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 227: 
      paramMessage = (PngFrameManager.RandomDrawableParam)paramMessage.obj;
      if (paramMessage.jdField_a_of_type_Long != paramMessage.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_Long) {
        return;
      }
      paramMessage.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramMessage.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramMessage.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_e_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)paramMessage.jdField_a_of_type_JavaLangObject);
      return;
    case 226: 
      paramMessage = (PngFrameManager.RandomDrawableParam)paramMessage.obj;
      paramMessage.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramMessage.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130847349);
      return;
    case 225: 
      paramMessage = (PngFrameManager.RandomDrawableParam)paramMessage.obj;
      paramMessage.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      f(paramMessage);
      return;
    }
    paramMessage = (PngFrameManager.RandomDrawableParam)paramMessage.obj;
    paramMessage.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_e_of_type_Int = paramMessage.jdField_a_of_type_Int;
    if (paramMessage.jdField_a_of_type_Int == 0)
    {
      a(paramMessage);
      return;
    }
    if (paramMessage.jdField_a_of_type_Int == 1) {
      c(paramMessage);
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "PngFrameManager 【onDestroy】  ");
    }
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localObject != null)
    {
      ((ConcurrentHashMap)localObject).clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    }
    localObject = this.jdField_a_of_type_JavaUtilHashMap;
    if (localObject != null)
    {
      ((HashMap)localObject).clear();
      this.jdField_a_of_type_JavaUtilHashMap = null;
    }
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.drawable.PngFrameManager
 * JD-Core Version:    0.7.0.1
 */