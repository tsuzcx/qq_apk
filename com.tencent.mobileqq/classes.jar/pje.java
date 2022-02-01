import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.common.RIJUserInfoUtil.requestUserInfo.runnable.1;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/common/RIJUserInfoUtil;", "", "()V", "TAG", "", "realtimeSwitch", "", "addUinToList", "", "uinList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "uin", "init", "requestUserInfo", "articleInfoList", "", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "channelId", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class pje
{
  public static final pje a;
  private static boolean a;
  
  static
  {
    jdField_a_of_type_Pje = new pje();
  }
  
  private final void a(ArrayList<String> paramArrayList, String paramString)
  {
    if ((!TextUtils.isEmpty((CharSequence)paramString)) && (!CollectionsKt.contains((Iterable)paramArrayList, paramString)) && (paramString != null)) {
      paramArrayList.add(paramString);
    }
  }
  
  public final void a()
  {
    boolean bool = false;
    AladdinConfig localAladdinConfig = Aladdin.getConfig(396);
    if (localAladdinConfig != null) {}
    for (int i = localAladdinConfig.getIntegerFromString("realtimeSwitch", 0);; i = 0)
    {
      if (i == 1) {
        bool = true;
      }
      jdField_a_of_type_Boolean = bool;
      QLog.i("RIJUserInfoUtil", 1, "[init] realtimeSwitch = " + jdField_a_of_type_Boolean);
      return;
    }
  }
  
  public final void a(@Nullable List<? extends ArticleInfo> paramList, int paramInt)
  {
    ThreadManager.excute((Runnable)new RIJUserInfoUtil.requestUserInfo.runnable.1(paramInt, paramList), 128, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pje
 * JD-Core Version:    0.7.0.1
 */