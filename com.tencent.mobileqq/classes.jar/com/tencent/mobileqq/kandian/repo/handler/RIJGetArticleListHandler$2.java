package com.tencent.mobileqq.kandian.repo.handler;

import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.base.utils.RIJThreadHandler;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyChannelActivity;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.msf.ReadInJoyMSFHandlerUtils;
import com.tencent.mobileqq.kandian.glue.pts.PTSPreLayoutHandler;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModuleUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJArticleInfoRepo;
import com.tencent.mobileqq.kandian.repo.feeds.SelectPositionModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PositionData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyRequestParams.Request0x68bParams;
import com.tencent.mobileqq.kandian.repo.xtab.api.impl.RIJXTabConfigHandler;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class RIJGetArticleListHandler$2
  implements Runnable
{
  RIJGetArticleListHandler$2(RIJGetArticleListHandler paramRIJGetArticleListHandler, String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean, int paramInt7) {}
  
  public void run()
  {
    Object localObject1 = this.this$0.d;
    Object localObject2 = this.a;
    int k = this.b;
    long l = this.c;
    int m = this.d;
    localObject1 = ((EntityManager)localObject1).query(BaseArticleInfo.class, true, (String)localObject2, new String[] { String.valueOf(k), String.valueOf(l) }, null, null, "mRecommendSeq desc", String.valueOf(m));
    if (localObject1 != null) {
      ReadInJoyMSFHandlerUtils.d((List)localObject1);
    }
    if ((localObject1 != null) && (this.d == ((List)localObject1).size()))
    {
      this.this$0.a.i().a(Integer.valueOf(this.b), (List)localObject1, false);
      PTSPreLayoutHandler.a((List)localObject1);
      localObject1 = this.this$0.a.i().b(Integer.valueOf(this.b));
      this.this$0.b.post(new RIJGetArticleListHandler.2.2(this, (List)localObject1));
      return;
    }
    if (this.b == 70)
    {
      k = -1;
      if (this.this$0.c != null) {
        k = ((KandianMergeManager)this.this$0.c.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).b();
      }
      if (k < 0)
      {
        ReadInJoyLogicEngine.a().b(false);
        return;
      }
      this.this$0.a.i().a(Integer.valueOf(this.b), (List)localObject1, false);
      localObject1 = this.this$0.a.i().b(Integer.valueOf(this.b));
      this.this$0.b.post(new RIJGetArticleListHandler.2.1(this, (List)localObject1));
      return;
    }
    localObject1 = new ReadInJoyRequestParams.Request0x68bParams();
    ((ReadInJoyRequestParams.Request0x68bParams)localObject1).b = this.b;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject1).f = false;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject1).g = null;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject1).h = false;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject1).i = null;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject1).j = true;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject1).o = ArticleInfoModuleUtils.b();
    ((ReadInJoyRequestParams.Request0x68bParams)localObject1).r = this.e;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject1).A = this.f;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject1).F |= this.g;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject1).p = this.h;
    if (this.i)
    {
      ((ReadInJoyRequestParams.Request0x68bParams)localObject1).c = this.c;
      ((ReadInJoyRequestParams.Request0x68bParams)localObject1).d = -1L;
    }
    else
    {
      ((ReadInJoyRequestParams.Request0x68bParams)localObject1).c = -1L;
      ((ReadInJoyRequestParams.Request0x68bParams)localObject1).d = this.c;
    }
    if (this.j == 0)
    {
      ((ReadInJoyRequestParams.Request0x68bParams)localObject1).y |= 0x10;
      ((ReadInJoyRequestParams.Request0x68bParams)localObject1).y |= 0x20;
      ((ReadInJoyRequestParams.Request0x68bParams)localObject1).y |= 0x100;
      ((ReadInJoyRequestParams.Request0x68bParams)localObject1).y |= 0x40;
      ((ReadInJoyRequestParams.Request0x68bParams)localObject1).y |= 0x400;
      if (this.b == 56) {
        ((ReadInJoyRequestParams.Request0x68bParams)localObject1).y |= 0x1080;
      }
      if (this.b == 0) {
        ((ReadInJoyRequestParams.Request0x68bParams)localObject1).y |= 0x800;
      }
    }
    if (this.b == 40677) {
      ((ReadInJoyRequestParams.Request0x68bParams)localObject1).G = 2;
    }
    if (DailyModeConfigHandler.c(this.b)) {
      ((ReadInJoyRequestParams.Request0x68bParams)localObject1).G = 3;
    }
    if (!RIJShowKanDianTabSp.c()) {
      ((ReadInJoyRequestParams.Request0x68bParams)localObject1).F |= 0x200;
    }
    if (RIJXTabConfigHandler.INSTANCE.isBigImageMode()) {
      ((ReadInJoyRequestParams.Request0x68bParams)localObject1).F |= 0x80000;
    }
    if (ReadInJoyChannelActivity.d()) {
      ((ReadInJoyRequestParams.Request0x68bParams)localObject1).F |= 0x100000;
    }
    QLog.d("RIJGetArticleListHandler", 1, new Object[] { "68b params recommendFlag = ", Integer.valueOf(((ReadInJoyRequestParams.Request0x68bParams)localObject1).F) });
    if (this.b == 41695)
    {
      localObject2 = ReadInJoyLogicEngine.a().j();
      if (localObject2 != null)
      {
        localObject2 = ((SelectPositionModule)localObject2).b();
        if (localObject2 != null)
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("loadMoreChannelArticleList positionData = ");
            localStringBuilder.append(localObject2);
            QLog.i("RIJGetArticleListHandler", 2, localStringBuilder.toString());
          }
          ((ReadInJoyRequestParams.Request0x68bParams)localObject1).K = new PositionData();
          ((ReadInJoyRequestParams.Request0x68bParams)localObject1).K.copy((PositionData)localObject2);
        }
      }
    }
    RIJThreadHandler.a(this.f);
    this.this$0.a((ReadInJoyRequestParams.Request0x68bParams)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.handler.RIJGetArticleListHandler.2
 * JD-Core Version:    0.7.0.1
 */