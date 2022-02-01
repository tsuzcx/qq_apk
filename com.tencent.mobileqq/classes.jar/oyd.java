import com.tencent.biz.pubaccount.readinjoy.channelbanner.RIJChannelBannerReport.reportAllData.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/channelbanner/RIJChannelBannerReport;", "", "()V", "avatarCardClickMap", "Ljava/util/HashMap;", "", "Lcom/tencent/biz/pubaccount/readinjoy/channelbanner/RIJChannelBannerReport$R5Builder;", "Lkotlin/collections/HashMap;", "getAvatarCardClickMap", "()Ljava/util/HashMap;", "avatarCardExposureMap", "getAvatarCardExposureMap", "avatarItemClickMap", "getAvatarItemClickMap", "avatarItemExposureMap", "getAvatarItemExposureMap", "getBaseR5Builder", "channelBannerInfo", "Lcom/tencent/biz/pubaccount/readinjoy/channelbanner/RIJChannelBannerModule$ChannelBannerInfo;", "Lcom/tencent/biz/pubaccount/readinjoy/channelbanner/RIJChannelBannerModule;", "reportAllData", "", "reportDataImp", "actionName", "r5Builder", "Companion", "R5Builder", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class oyd
{
  public static final oye a;
  @NotNull
  private final HashMap<String, oyf> a;
  @NotNull
  private final HashMap<String, oyf> b = new HashMap();
  @NotNull
  private final HashMap<String, oyf> c = new HashMap();
  @NotNull
  private final HashMap<String, oyf> d = new HashMap();
  
  static
  {
    jdField_a_of_type_Oye = new oye(null);
  }
  
  public oyd()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private final void a(String paramString, oyf paramoyf)
  {
    paramoyf = paramoyf.a();
    QLog.i("RIJChannelBannerReport", 1, "[reportDataImp], actionName = " + paramString + ", r5 = " + paramoyf);
    olh.a(null, "", paramString, paramString, 0, 0, "", "", "", paramoyf, false);
  }
  
  @NotNull
  public final HashMap<String, oyf> a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  @NotNull
  public final oyf a(@NotNull oyb paramoyb)
  {
    Intrinsics.checkParameterIsNotNull(paramoyb, "channelBannerInfo");
    return new oyf().a("channel_id", String.valueOf(paramoyb.a())).a(paramoyb.d());
  }
  
  public final void a()
  {
    Map localMap1 = MapsKt.toMutableMap((Map)this.jdField_a_of_type_JavaUtilHashMap);
    Map localMap2 = MapsKt.toMutableMap((Map)this.b);
    Map localMap3 = MapsKt.toMutableMap((Map)this.c);
    Map localMap4 = MapsKt.toMutableMap((Map)this.d);
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.b.clear();
    this.c.clear();
    this.d.clear();
    ThreadManager.executeOnSubThread((Runnable)new RIJChannelBannerReport.reportAllData.1(this, localMap1, localMap2, localMap3, localMap4));
  }
  
  @NotNull
  public final HashMap<String, oyf> b()
  {
    return this.b;
  }
  
  @NotNull
  public final HashMap<String, oyf> c()
  {
    return this.c;
  }
  
  @NotNull
  public final HashMap<String, oyf> d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oyd
 * JD-Core Version:    0.7.0.1
 */