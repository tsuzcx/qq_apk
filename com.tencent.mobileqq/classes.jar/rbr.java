import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/service/redpacket/RIJAidlServerRedPacketModule;", "Lcom/tencent/biz/pubaccount/readinjoy/service/redpacket/IRIJAidlInterfaceForRedPacket$Stub;", "()V", "currentTaskContentType", "", "currentTaskRowkey", "", "currentTaskTimeInMs", "hasLoadFromDB", "", "maxTaskTimePerContentInMs", "canDoTaskThisTime", "getArticleShareWording", "getCurrentContentTaskRowkey", "getCurrentContentTaskTimeInMs", "getCurrentContentType", "getGlobalCurrentTaskTimeInMs", "getGlobalTotalTaskTimeInMs", "getLastTaskContentRowkey", "getLastTaskTimeForContentInMs", "getMaxTaskTimePerContentInMs", "getMaxTaskTimeWhenArticleStationary", "getMaximumTaskTimeForArticleInMs", "getShareTipsShowDurationInMs", "getTaskTimeFromCache", "rowKey", "getTaskTimePerRoundInMs", "getTipsShowTimeInMs", "getTotalRound", "hasRead", "hasRedPacketPermission", "isHighestRedPacketAuthorityOn", "isNowInKanDianTab", "reportTaskProgress", "", "rowkey", "type", "taskTimeInMs", "callback", "Lcom/tencent/biz/pubaccount/readinjoy/service/redpacket/IReportTaskProgressCallback;", "requestShouldDoTaskTiming", "Lcom/tencent/biz/pubaccount/readinjoy/service/redpacket/IShouldDoTaskTimingCallback;", "saveTaskTimeToCache", "setCanDoTaskThisTime", "canDoTask", "nextRequestCanDoTaskTs", "", "setCurrentContentTaskRowkey", "setCurrentContentTaskTimeInMs", "setCurrentContentType", "setGlobalCurrentTaskTimeInMs", "curTaskTime", "setLastTaskTimeForContent", "setMaxTaskTimePerContent", "maxTaskTimeInMs", "setRead", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class rbr
  extends rbg
{
  public static final rbs a;
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c = 20000;
  
  static
  {
    jdField_a_of_type_Rbs = new rbs(null);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NotNull
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowkey");
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowkey");
    RIJRedPacketManager.a().a(paramString, paramInt);
  }
  
  public void a(@Nullable String paramString, int paramInt1, int paramInt2, @Nullable rbi paramrbi)
  {
    RIJRedPacketManager.a().a(paramString, paramInt1, paramInt2, (qza)new rbu(paramrbi));
  }
  
  public void a(@NotNull rbl paramrbl)
  {
    Intrinsics.checkParameterIsNotNull(paramrbl, "callback");
    RIJRedPacketManager.a().a(1, (qzb)new rbv(paramrbl));
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    RIJRedPacketManager.a().a(paramBoolean, paramLong);
  }
  
  public boolean a()
  {
    return RIJRedPacketManager.a().d();
  }
  
  public boolean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowKey");
    return RIJRedPacketManager.a().a(paramString);
  }
  
  public int b()
  {
    return this.b;
  }
  
  @NotNull
  public String b()
  {
    Object localObject = RIJRedPacketManager.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "RIJRedPacketManager.getInstance()");
    localObject = ((RIJRedPacketManager)localObject).b();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "RIJRedPacketManager.getI…e().lastTaskContentRowkey");
    return localObject;
  }
  
  public void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowKey");
    RIJRedPacketManager.a().a(paramString);
  }
  
  public boolean b()
  {
    return RIJRedPacketManager.a().c();
  }
  
  public boolean b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowKey");
    boolean bool = RIJRedPacketManager.a().a(paramString);
    if ((!bool) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      RIJRedPacketManager.a().a(paramString, (qyy)new rbt(this, paramString));
    }
    return bool;
  }
  
  public int c()
  {
    RIJRedPacketManager localRIJRedPacketManager = RIJRedPacketManager.a();
    Intrinsics.checkExpressionValueIsNotNull(localRIJRedPacketManager, "RIJRedPacketManager.getInstance()");
    return localRIJRedPacketManager.i();
  }
  
  @NotNull
  public String c()
  {
    Object localObject = RIJRedPacketManager.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "RIJRedPacketManager.getInstance()");
    localObject = ((RIJRedPacketManager)localObject).c();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "RIJRedPacketManager.getI…nce().articleShareWording");
    return localObject;
  }
  
  public void c(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowKey");
    b(paramString);
    RIJRedPacketManager.a().b(paramString);
  }
  
  public boolean c()
  {
    RIJRedPacketManager localRIJRedPacketManager = RIJRedPacketManager.a();
    Intrinsics.checkExpressionValueIsNotNull(localRIJRedPacketManager, "RIJRedPacketManager.getInstance()");
    return localRIJRedPacketManager.e();
  }
  
  public int d()
  {
    return h() / c();
  }
  
  public void d(int paramInt)
  {
    RIJRedPacketManager.a().a(paramInt);
  }
  
  public boolean d()
  {
    return ReadinjoyTabFrame.d_();
  }
  
  public int e()
  {
    return this.c;
  }
  
  public int f()
  {
    RIJRedPacketManager localRIJRedPacketManager = RIJRedPacketManager.a();
    Intrinsics.checkExpressionValueIsNotNull(localRIJRedPacketManager, "RIJRedPacketManager.getInstance()");
    return localRIJRedPacketManager.f();
  }
  
  public int g()
  {
    RIJRedPacketManager localRIJRedPacketManager = RIJRedPacketManager.a();
    Intrinsics.checkExpressionValueIsNotNull(localRIJRedPacketManager, "RIJRedPacketManager.getInstance()");
    return localRIJRedPacketManager.a();
  }
  
  public int h()
  {
    RIJRedPacketManager localRIJRedPacketManager = RIJRedPacketManager.a();
    Intrinsics.checkExpressionValueIsNotNull(localRIJRedPacketManager, "RIJRedPacketManager.getInstance()");
    return localRIJRedPacketManager.b();
  }
  
  public int i()
  {
    RIJRedPacketManager localRIJRedPacketManager = RIJRedPacketManager.a();
    Intrinsics.checkExpressionValueIsNotNull(localRIJRedPacketManager, "RIJRedPacketManager.getInstance()");
    return localRIJRedPacketManager.h();
  }
  
  public int j()
  {
    RIJRedPacketManager localRIJRedPacketManager = RIJRedPacketManager.a();
    Intrinsics.checkExpressionValueIsNotNull(localRIJRedPacketManager, "RIJRedPacketManager.getInstance()");
    return localRIJRedPacketManager.c();
  }
  
  public int k()
  {
    RIJRedPacketManager localRIJRedPacketManager = RIJRedPacketManager.a();
    Intrinsics.checkExpressionValueIsNotNull(localRIJRedPacketManager, "RIJRedPacketManager.getInstance()");
    return localRIJRedPacketManager.g();
  }
  
  public int l()
  {
    RIJRedPacketManager localRIJRedPacketManager = RIJRedPacketManager.a();
    Intrinsics.checkExpressionValueIsNotNull(localRIJRedPacketManager, "RIJRedPacketManager.getInstance()");
    return localRIJRedPacketManager.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rbr
 * JD-Core Version:    0.7.0.1
 */