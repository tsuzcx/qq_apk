package com.tencent.mobileqq.imaxad.inject;

import android.content.Context;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.imaxad.ImaxadThirdProcessorImpl;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ImaxadThirdProcessorProxy
{
  @ConfigInject(configPath="Business/qqad-api/src/main/resources/Inject_AdInject.yml", version=1)
  public static ArrayList<Class<? extends IImaxadThirdProcessor>> a;
  public IImaxadThirdProcessor a;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilArrayList.add(ImaxadThirdProcessorImpl.class);
  }
  
  public ImaxadThirdProcessorProxy()
  {
    this.jdField_a_of_type_ComTencentMobileqqImaxadInjectIImaxadThirdProcessor = null;
  }
  
  public long a()
  {
    a();
    IImaxadThirdProcessor localIImaxadThirdProcessor = this.jdField_a_of_type_ComTencentMobileqqImaxadInjectIImaxadThirdProcessor;
    if (localIImaxadThirdProcessor != null) {
      return localIImaxadThirdProcessor.a();
    }
    return 0L;
  }
  
  public URLDrawable a(String paramString)
  {
    a();
    IImaxadThirdProcessor localIImaxadThirdProcessor = this.jdField_a_of_type_ComTencentMobileqqImaxadInjectIImaxadThirdProcessor;
    if (localIImaxadThirdProcessor != null) {
      localIImaxadThirdProcessor.a(paramString);
    }
    return null;
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqImaxadInjectIImaxadThirdProcessor == null)
      {
        if (jdField_a_of_type_JavaUtilArrayList != null)
        {
          boolean bool = jdField_a_of_type_JavaUtilArrayList.isEmpty();
          if (!bool)
          {
            try
            {
              this.jdField_a_of_type_ComTencentMobileqqImaxadInjectIImaxadThirdProcessor = ((IImaxadThirdProcessor)((Class)jdField_a_of_type_JavaUtilArrayList.get(0)).newInstance());
            }
            catch (Exception localException)
            {
              QLog.e("ImaxadThirdProcessorProxy", 1, localException, new Object[0]);
            }
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("initProcessor size = ");
            localStringBuilder.append(jdField_a_of_type_JavaUtilArrayList.size());
            QLog.i("ImaxadThirdProcessorProxy", 1, localStringBuilder.toString());
            break label108;
          }
        }
        QLog.i("ImaxadThirdProcessorProxy", 1, "initProcessor is empty ");
      }
      label108:
      return;
    }
    finally {}
  }
  
  public void a(AdvertisementItem paramAdvertisementItem, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    a();
    IImaxadThirdProcessor localIImaxadThirdProcessor = this.jdField_a_of_type_ComTencentMobileqqImaxadInjectIImaxadThirdProcessor;
    if (localIImaxadThirdProcessor != null) {
      localIImaxadThirdProcessor.a(paramAdvertisementItem, paramContext, paramString1, paramString2, paramString3, paramString4);
    }
  }
  
  public void a(AdvertisementItem paramAdvertisementItem, URLDrawable paramURLDrawable, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    a();
    IImaxadThirdProcessor localIImaxadThirdProcessor = this.jdField_a_of_type_ComTencentMobileqqImaxadInjectIImaxadThirdProcessor;
    if (localIImaxadThirdProcessor != null) {
      localIImaxadThirdProcessor.a(paramAdvertisementItem, paramURLDrawable, paramContext, paramString1, paramString2, paramString3, paramString4, paramInt);
    }
  }
  
  public void a(AppInterface paramAppInterface, int paramInt, AdvertisementItem paramAdvertisementItem)
  {
    a();
    IImaxadThirdProcessor localIImaxadThirdProcessor = this.jdField_a_of_type_ComTencentMobileqqImaxadInjectIImaxadThirdProcessor;
    if (localIImaxadThirdProcessor != null) {
      localIImaxadThirdProcessor.a(paramAppInterface, paramInt, paramAdvertisementItem);
    }
  }
  
  public void b(AdvertisementItem paramAdvertisementItem, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    a();
    IImaxadThirdProcessor localIImaxadThirdProcessor = this.jdField_a_of_type_ComTencentMobileqqImaxadInjectIImaxadThirdProcessor;
    if (localIImaxadThirdProcessor != null) {
      localIImaxadThirdProcessor.b(paramAdvertisementItem, paramContext, paramString1, paramString2, paramString3, paramString4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.inject.ImaxadThirdProcessorProxy
 * JD-Core Version:    0.7.0.1
 */