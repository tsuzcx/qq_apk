import com.tencent.qqlive.module.videoreport.PageParams;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/dt/RIJDtParamBuilder;", "", "()V", "params", "Ljava/util/HashMap;", "", "addChannelID", "channelID", "", "addElementID", "id", "addRowkey", "rowkey", "build", "", "buildPageParams", "Lcom/tencent/qqlive/module/videoreport/PageParams;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class pda
{
  private final HashMap<String, Object> a = new HashMap();
  
  public pda()
  {
    Map localMap = (Map)this.a;
    String str = pcz.a;
    Intrinsics.checkExpressionValueIsNotNull(str, "RIJDtConstant.APP_KEY");
    localMap.put("dt_appkey", str);
  }
  
  @NotNull
  public final PageParams a()
  {
    return new PageParams((Map)this.a);
  }
  
  @NotNull
  public final Map<String, Object> a()
  {
    return (Map)this.a;
  }
  
  @NotNull
  public final pda a(long paramLong)
  {
    ((Map)this.a).put("channel_id", Long.valueOf(paramLong));
    return this;
  }
  
  @NotNull
  public final pda a(@Nullable String paramString)
  {
    Map localMap = (Map)this.a;
    if (paramString != null) {}
    for (;;)
    {
      localMap.put("rowkey", paramString);
      return this;
      paramString = "null";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pda
 * JD-Core Version:    0.7.0.1
 */