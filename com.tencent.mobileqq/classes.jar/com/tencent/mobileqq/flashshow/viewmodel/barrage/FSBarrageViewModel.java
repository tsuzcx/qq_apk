package com.tencent.mobileqq.flashshow.viewmodel.barrage;

import android.content.Context;
import android.view.TextureView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.flashshow.api.bean.FSReportBean;
import com.tencent.mobileqq.flashshow.config.FSConfig;
import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11002;
import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11002.DataBuilder;
import com.tencent.mobileqq.flashshow.thread.FSThreadUtils;
import com.tencent.mobileqq.flashshow.utils.FSSafeListUtils;
import com.tencent.mobileqq.flashshow.viewmodel.barrage.holder.bean.BarrageHolderParam;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rfw.barrage.core.RFWBarrageManager;
import com.tencent.rfw.barrage.data.RFWBaseBarrage;
import com.tencent.rfw.barrage.inject.RFWBarrageContext;
import com.tencent.rfw.barrage.inject.RFWBarrageContext.Builder;
import com.tencent.rfw.barrage.inject.RFWVideoBarrageConfig;
import com.tencent.rfw.barrage.inject.RFWWindowConfig;
import com.tencent.rfw.barrage.util.RFWBarragePlayerTimerUtils;
import com.tencent.rfw.barrage.util.RFWBarrageTimeUtils;
import com.tencent.rfw.barrage.util.RFWBarrageTimeUtils.RFWUpdateBarrageTimeParam;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class FSBarrageViewModel
  implements IFSBarrageViewModel<FeedCloudMeta.StComment>
{
  private RFWBarrageManager a;
  private RFWBarrageContext.Builder b;
  private RFWWindowConfig c;
  private RFWBarragePlayerTimerUtils d;
  private IFSBarrageViewModel.OnMeasureBarrageListener e;
  private IFSBarrageViewModel.OnBarrageLoadMoreListener f;
  private IFSBarrageViewModel.OnBarrageClickPopupListener g;
  private FeedCloudMeta.StFeed h;
  private FSReportBean i;
  private RFWBaseBarrage j = null;
  private int k = 0;
  
  private RFWBaseBarrage a(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    if (this.a == null)
    {
      QLog.d("DM-FSBarrageViewModel", 1, "[setDataSource] barrage manager should not is null.");
      return null;
    }
    String str = b(this.h);
    BarrageHolderParam localBarrageHolderParam = new BarrageHolderParam();
    localBarrageHolderParam.a(paramStComment);
    localBarrageHolderParam.a(paramStReply);
    localBarrageHolderParam.a(str);
    return this.a.a(-2147483647, localBarrageHolderParam);
  }
  
  private RFWBarrageContext.Builder a(Context paramContext)
  {
    RFWBarrageContext.Builder localBuilder = RFWBarrageContext.i();
    localBuilder.a(new FSBarrageViewModel.BarragePlayTimeSupplier(this));
    localBuilder.a(-10);
    localBuilder.a(new FSBusinessBarrageRender(paramContext));
    localBuilder.a(new FSBarrageViewModel.FSBarrageExportImpl(this));
    return localBuilder;
  }
  
  private List<RFWBaseBarrage> a(@NonNull FeedCloudMeta.StComment paramStComment)
  {
    Object localObject = paramStComment.vecReply.get();
    if (FSSafeListUtils.a((List)localObject)) {
      return null;
    }
    paramStComment = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramStComment.add(a(null, (FeedCloudMeta.StReply)((Iterator)localObject).next()));
    }
    return paramStComment;
  }
  
  private List<RFWBaseBarrage> a(List<FeedCloudMeta.StComment> paramList)
  {
    if (FSSafeListUtils.a(paramList))
    {
      QLog.d("DM-FSBarrageViewModel", 1, "[convertCommentsToBarrageList] source not is empty.");
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int m = 0;
    while (m < paramList.size())
    {
      Object localObject = (FeedCloudMeta.StComment)FSSafeListUtils.a(paramList, m);
      localArrayList.add(a((FeedCloudMeta.StComment)localObject, null));
      localObject = a((FeedCloudMeta.StComment)localObject);
      if (!FSSafeListUtils.a((List)localObject)) {
        localArrayList.addAll((Collection)localObject);
      }
      m += 1;
    }
    return localArrayList;
  }
  
  private void a(BarrageHolderParam paramBarrageHolderParam)
  {
    IFSBarrageViewModel.OnBarrageClickPopupListener localOnBarrageClickPopupListener = this.g;
    if (localOnBarrageClickPopupListener == null)
    {
      QLog.d("DM-FSBarrageViewModel", 1, "[handleBarrageClick] barrage click popup listener should not be null.");
      return;
    }
    localOnBarrageClickPopupListener.a(paramBarrageHolderParam);
  }
  
  private void a(RFWBaseBarrage paramRFWBaseBarrage)
  {
    if (!q())
    {
      QLog.d("DM-FSBarrageViewModel", 1, "[handlerBarrageClick] current wns not enabled.");
      return;
    }
    if (paramRFWBaseBarrage == null)
    {
      QLog.d("DM-FSBarrageViewModel", 1, "[handlerBarrageClick] barrage should not be null.");
      return;
    }
    Object localObject = paramRFWBaseBarrage.r();
    if (!(localObject instanceof BarrageHolderParam))
    {
      QLog.d("DM-FSBarrageViewModel", 1, new Object[] { "[handlerBarrageClick] data type not is comment, data: ", localObject });
      return;
    }
    this.j = paramRFWBaseBarrage;
    a((BarrageHolderParam)localObject);
    b(true);
  }
  
  private void a(boolean paramBoolean)
  {
    IFSBarrageViewModel.OnMeasureBarrageListener localOnMeasureBarrageListener = this.e;
    if (localOnMeasureBarrageListener == null)
    {
      QLog.d("DM-FSBarrageViewModel", 1, "[setDataSource] barrage listener should not be null.");
      return;
    }
    localOnMeasureBarrageListener.a(paramBoolean);
  }
  
  private String b(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {
      paramStFeed = null;
    } else {
      paramStFeed = paramStFeed.poster;
    }
    if (paramStFeed == null) {
      return null;
    }
    return paramStFeed.id.get();
  }
  
  private void b(RFWBaseBarrage paramRFWBaseBarrage)
  {
    if (paramRFWBaseBarrage == null)
    {
      QLog.d("DM-FSBarrageViewModel", 1, "[reportBarrageExposure] danmaku should not be null.");
      return;
    }
    if (FSBarrageViewTypeUtils.a(paramRFWBaseBarrage.r()) == 2) {
      FSLpReportDc11002.a(new FSLpReportDc11002.DataBuilder(this.h, this.i).a(84).b(1).p(String.valueOf(1)));
    }
  }
  
  private void b(List<RFWBaseBarrage> paramList, int paramInt, long paramLong)
  {
    if (this.a == null)
    {
      QLog.d("DM-FSBarrageViewModel", 1, "[updateBarrageDataSource] barrage manager should not be null.");
      return;
    }
    int m = 0;
    while (m < paramList.size())
    {
      RFWBaseBarrage localRFWBaseBarrage1 = (RFWBaseBarrage)FSSafeListUtils.a(paramList, m);
      this.a.a(localRFWBaseBarrage1);
      RFWBaseBarrage localRFWBaseBarrage2 = (RFWBaseBarrage)FSSafeListUtils.a(paramList, m - 3);
      RFWBarrageTimeUtils.a(new RFWBarrageTimeUtils.RFWUpdateBarrageTimeParam().a(localRFWBaseBarrage1).b(localRFWBaseBarrage2).a(paramInt).a(paramLong).b(m));
      this.a.b(localRFWBaseBarrage1);
      m += 1;
    }
    QLog.d("DM-FSBarrageViewModel", 1, new Object[] { "[setDataSource] barrages count: ", Integer.valueOf(paramList.size()), " | hash code:", Integer.valueOf(hashCode()) });
    FSThreadUtils.b(new FSBarrageViewModel.FSBarrageMeasureImpl(this, false));
  }
  
  private void b(List<RFWBaseBarrage> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    if (this.a == null)
    {
      QLog.d("DM-FSBarrageViewModel", 1, "[updateBarrageDataSource] barrage manager should not be null.");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("barrage count: ");
    ((StringBuilder)localObject).append(FSSafeListUtils.b(paramList));
    ((StringBuilder)localObject).append(" | totalCount: ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" | duration: ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" | startIndex: ");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.d("DM-FSBarrageViewModel", 1, new Object[] { "[appendBarrageDataSource] ", ((StringBuilder)localObject).toString() });
    int m = 0;
    while (m < paramList.size())
    {
      localObject = (RFWBaseBarrage)FSSafeListUtils.a(paramList, m);
      this.a.a((RFWBaseBarrage)localObject);
      int n = paramInt2 + m;
      RFWBaseBarrage localRFWBaseBarrage = (RFWBaseBarrage)FSSafeListUtils.a(paramList, n - 3);
      RFWBarrageTimeUtils.a(new RFWBarrageTimeUtils.RFWUpdateBarrageTimeParam().a((RFWBaseBarrage)localObject).b(localRFWBaseBarrage).a(paramInt1).a(paramLong).b(n));
      this.a.b((RFWBaseBarrage)localObject);
      m += 1;
    }
    this.a.a(false);
    FSThreadUtils.b(new FSBarrageViewModel.FSBarrageMeasureImpl(this, true));
  }
  
  private void b(boolean paramBoolean)
  {
    RFWBaseBarrage localRFWBaseBarrage = this.j;
    if (localRFWBaseBarrage == null)
    {
      QLog.d("DM-FSBarrageViewModel", 1, "[updateBarrageClickState] current click barrage should not be null.");
      return;
    }
    localRFWBaseBarrage.a(paramBoolean);
    if (paramBoolean)
    {
      this.j.d();
      return;
    }
    this.j.f();
  }
  
  private void h()
  {
    if (this.d == null) {
      this.d = RFWBarragePlayerTimerUtils.a();
    }
    this.d.b();
  }
  
  private void i()
  {
    RFWBarragePlayerTimerUtils localRFWBarragePlayerTimerUtils = this.d;
    if (localRFWBarragePlayerTimerUtils == null) {
      return;
    }
    localRFWBarragePlayerTimerUtils.d();
  }
  
  private void j()
  {
    RFWBarragePlayerTimerUtils localRFWBarragePlayerTimerUtils = this.d;
    if (localRFWBarragePlayerTimerUtils == null) {
      return;
    }
    localRFWBarragePlayerTimerUtils.e();
  }
  
  private void k()
  {
    RFWBarragePlayerTimerUtils localRFWBarragePlayerTimerUtils = this.d;
    if (localRFWBarragePlayerTimerUtils == null) {
      return;
    }
    localRFWBarragePlayerTimerUtils.c();
  }
  
  private void l()
  {
    RFWBarragePlayerTimerUtils localRFWBarragePlayerTimerUtils = this.d;
    if (localRFWBarragePlayerTimerUtils == null) {
      return;
    }
    localRFWBarragePlayerTimerUtils.f();
  }
  
  private void m()
  {
    this.c = RFWBarrageContext.a();
    this.c.a(3);
    this.c.f(10.0F);
    this.c.c(10.0F);
    this.c.b(10.0F);
    this.c.b(q());
    this.c.d(true);
  }
  
  private long n()
  {
    RFWBarragePlayerTimerUtils localRFWBarragePlayerTimerUtils = this.d;
    if (localRFWBarragePlayerTimerUtils == null) {
      return -1L;
    }
    return localRFWBarragePlayerTimerUtils.g();
  }
  
  private void o()
  {
    IFSBarrageViewModel.OnBarrageLoadMoreListener localOnBarrageLoadMoreListener = this.f;
    if (localOnBarrageLoadMoreListener == null)
    {
      QLog.d("DM-FSBarrageViewModel", 1, "[handleBarrageLoadMore] barrage load more listener should not be null.");
      return;
    }
    localOnBarrageLoadMoreListener.a();
  }
  
  private void p()
  {
    RFWBarrageManager localRFWBarrageManager = this.a;
    if (localRFWBarrageManager == null)
    {
      QLog.d("DM-FSBarrageViewModel", 1, "[handlerSourceDrawFinish] barrage manager should not is null.");
      return;
    }
    if (localRFWBarrageManager.i())
    {
      QLog.d("DM-FSBarrageViewModel", 1, "[handlerSourceDrawFinish] barrage manager pause handler.");
      d();
    }
  }
  
  private boolean q()
  {
    boolean bool = false;
    if (FSConfig.a("qqflash", "qqflash_show_barrage_report_enabled", Integer.valueOf(0)).intValue() == 1) {
      bool = true;
    }
    return bool;
  }
  
  public void a()
  {
    if (this.a == null)
    {
      QLog.d("DM-FSBarrageViewModel", 1, "[start] barrage manager should not be null.");
      return;
    }
    QLog.d("DM-FSBarrageViewModel", 1, new Object[] { "[start] barrage start, hash code: ", Integer.valueOf(hashCode()) });
    this.k = 1;
    this.a.b();
    h();
  }
  
  public void a(Context paramContext, TextureView paramTextureView)
  {
    m();
    this.b = a(paramContext);
    this.a = new RFWBarrageManager(paramTextureView, this.b.a());
    this.a.a(new FSBarrageViewModel.BarragePlayListener(this));
    RFWVideoBarrageConfig.a(new FSBarrageViewModel.BarrageLoggerProxy(null));
  }
  
  public void a(FSReportBean paramFSReportBean)
  {
    this.i = paramFSReportBean;
  }
  
  public void a(IFSBarrageViewModel.OnBarrageClickPopupListener paramOnBarrageClickPopupListener)
  {
    this.g = paramOnBarrageClickPopupListener;
  }
  
  public void a(IFSBarrageViewModel.OnBarrageLoadMoreListener paramOnBarrageLoadMoreListener)
  {
    this.f = paramOnBarrageLoadMoreListener;
  }
  
  public void a(IFSBarrageViewModel.OnMeasureBarrageListener paramOnMeasureBarrageListener)
  {
    this.e = paramOnMeasureBarrageListener;
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed)
  {
    this.h = paramStFeed;
  }
  
  public void a(List<FeedCloudMeta.StComment> paramList, int paramInt, long paramLong)
  {
    paramList = a(paramList);
    if (FSSafeListUtils.a(paramList))
    {
      QLog.d("DM-FSBarrageViewModel", 1, "[setDataSource] barrages not is empty, handler fail.");
      return;
    }
    FSBarrageViewModel.AsyncUpdateDataSource localAsyncUpdateDataSource = new FSBarrageViewModel.AsyncUpdateDataSource(this);
    localAsyncUpdateDataSource.a(paramList);
    localAsyncUpdateDataSource.a(paramInt);
    localAsyncUpdateDataSource.a(false);
    localAsyncUpdateDataSource.a(paramLong);
    FSThreadUtils.d(localAsyncUpdateDataSource);
  }
  
  public void a(List<FeedCloudMeta.StComment> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    paramList = a(paramList);
    if (FSSafeListUtils.a(paramList))
    {
      QLog.d("DM-FSBarrageViewModel", 1, "[appendBarrages] barrages not is empty, handler fail.");
      return;
    }
    FSBarrageViewModel.AsyncUpdateDataSource localAsyncUpdateDataSource = new FSBarrageViewModel.AsyncUpdateDataSource(this);
    localAsyncUpdateDataSource.a(paramList);
    localAsyncUpdateDataSource.a(paramInt1);
    localAsyncUpdateDataSource.a(true);
    localAsyncUpdateDataSource.a(paramLong);
    localAsyncUpdateDataSource.b(paramInt2);
    FSThreadUtils.d(localAsyncUpdateDataSource);
  }
  
  public void b()
  {
    if (this.a == null)
    {
      QLog.d("DM-FSBarrageViewModel", 1, "[pause] barrage manager should not be null.");
      return;
    }
    QLog.d("DM-FSBarrageViewModel", 1, new Object[] { "[pause] barrage pause, hash code: ", Integer.valueOf(hashCode()) });
    this.k = 2;
    this.a.d();
    i();
  }
  
  public void c()
  {
    if (this.a == null)
    {
      QLog.d("DM-FSBarrageViewModel", 1, "[pause] barrage manager should not be null.");
      return;
    }
    QLog.d("DM-FSBarrageViewModel", 1, new Object[] { "[pause] barrage resume, hash code: ", Integer.valueOf(hashCode()) });
    this.k = 3;
    this.a.c();
    j();
  }
  
  public void d()
  {
    k();
    l();
    if (this.a == null)
    {
      QLog.d("DM-FSBarrageViewModel", 1, "[release] barrage manager should not be null.");
      return;
    }
    QLog.d("DM-FSBarrageViewModel", 1, new Object[] { "[destroy] barrage destroy, hash code: ", Integer.valueOf(hashCode()) });
    this.k = 4;
    this.a.a(false);
    this.a.e();
  }
  
  public FSReportBean e()
  {
    return this.i;
  }
  
  public int f()
  {
    return this.k;
  }
  
  public void g()
  {
    b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.viewmodel.barrage.FSBarrageViewModel
 * JD-Core Version:    0.7.0.1
 */