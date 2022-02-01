package com.tencent.mobileqq.persistence.bridge.verify;

import com.tencent.mobileqq.data.entitymanager.Interceptor;
import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.BMQQAccountTypeInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.CardProfileInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.CommonTableColumnCheckInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.ConfessConvInfoInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.ConversationInfoInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.DataLineRecordInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.DropTableInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.ECShopDataInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.FileManagerInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.ForceIgnoreInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.MPFileTaskInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.MessageRecordInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.PrinterItemMsgRecordInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.PubAccountNavigationMenuInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.QCallRecentInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.QCallRecordInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.QiDianCorpInfoInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.QiDianExternalInfoInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.QiDianInternalInfoInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.QiDianPAForWPAInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.QiDianProfileUIInfoInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.RecentUserInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.RoamDateInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.RouterMsgRecordInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.SystemOrNoEntityInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.TracePathDataInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.TracePointsDataInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.TroopAIOAppInfoInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.TroopBarDataInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.TroopFileTransferItemInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.TroopInfoInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.UinToTinyIdInterceptor;
import com.tencent.mobileqq.persistence.bridge.verify.interceptor.VideoRedBagDataInterceptor;
import java.util.ArrayList;
import java.util.List;

public class TableColumnCheckInterceptorProvider
  implements Provider<List<Interceptor<Class>>>
{
  private List<Interceptor<Class>> a = new ArrayList();
  
  public TableColumnCheckInterceptorProvider()
  {
    this.a.add(new FileManagerInterceptor());
    this.a.add(new DataLineRecordInterceptor());
    this.a.add(new MPFileTaskInterceptor());
    this.a.add(new PrinterItemMsgRecordInterceptor());
    this.a.add(new RouterMsgRecordInterceptor());
    this.a.add(new MessageRecordInterceptor());
    this.a.add(new RecentUserInterceptor());
    this.a.add(new QCallRecentInterceptor());
    this.a.add(new ConversationInfoInterceptor());
    this.a.add(new TroopBarDataInterceptor());
    this.a.add(new ECShopDataInterceptor());
    this.a.add(new TracePointsDataInterceptor());
    this.a.add(new TracePathDataInterceptor());
    this.a.add(new QiDianExternalInfoInterceptor());
    this.a.add(new QiDianProfileUIInfoInterceptor());
    this.a.add(new BMQQAccountTypeInterceptor());
    this.a.add(new PubAccountNavigationMenuInterceptor());
    this.a.add(new QiDianCorpInfoInterceptor());
    this.a.add(new QiDianInternalInfoInterceptor());
    this.a.add(new QiDianPAForWPAInterceptor());
    this.a.add(new TroopFileTransferItemInterceptor());
    this.a.add(new QCallRecordInterceptor());
    this.a.add(new RoamDateInterceptor());
    this.a.add(new CardProfileInterceptor());
    this.a.add(new TroopAIOAppInfoInterceptor());
    this.a.add(new TroopInfoInterceptor());
    this.a.add(new VideoRedBagDataInterceptor());
    this.a.add(new SystemOrNoEntityInterceptor());
    this.a.add(new ForceIgnoreInterceptor());
    this.a.add(new ConfessConvInfoInterceptor());
    this.a.add(new UinToTinyIdInterceptor());
    this.a.add(new DropTableInterceptor());
    this.a.add(new CommonTableColumnCheckInterceptor());
  }
  
  public List<Interceptor<Class>> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.verify.TableColumnCheckInterceptorProvider
 * JD-Core Version:    0.7.0.1
 */