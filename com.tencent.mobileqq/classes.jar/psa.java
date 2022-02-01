import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.RIJVideoViewInterceptor.preloadData.1;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/video/RIJVideoViewInterceptor;", "Lcom/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/RIJViewInterceptor;", "()V", "fetchFollowStatus", "", "articleInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;", "innerPreloadAvatar", "onBindView", "position", "", "preloadAvatarByImageManager", "avatarUrl", "", "preloadData", "userInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ReadInJoyUserInfo;", "shouldIntercept", "", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class psa
  implements ppj
{
  public static final psb a = new psb(null);
  
  private final void a(BaseArticleInfo paramBaseArticleInfo)
  {
    ThreadManager.getUIHandler().post((Runnable)new RIJVideoViewInterceptor.preloadData.1(this, paramBaseArticleInfo));
  }
  
  private final void a(ReadInJoyUserInfo paramReadInJoyUserInfo, BaseArticleInfo paramBaseArticleInfo)
  {
    paramReadInJoyUserInfo = ReadInJoyUserInfoModule.a(paramReadInJoyUserInfo);
    Intrinsics.checkExpressionValueIsNotNull(paramReadInJoyUserInfo, "headUrl");
    a(paramReadInJoyUserInfo);
    paramBaseArticleInfo.preloadAvatarUrl = paramReadInJoyUserInfo;
    if (QLog.isColorLevel()) {
      QLog.d("RIJVideoViewInterceptor", 2, "preloadAvatarByImageManager url:" + paramBaseArticleInfo.preloadAvatarUrl + " title:" + paramBaseArticleInfo.mTitle);
    }
  }
  
  private final void a(String paramString)
  {
    if (!TextUtils.isEmpty((CharSequence)paramString)) {}
    try
    {
      tlw localtlw = new tlw();
      localtlw.b = true;
      qdn.a.a(localtlw, paramString);
      tlv.a().a(localtlw, (tlu)new pse(paramString));
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("RIJVideoViewInterceptor", 1, "preloadAvatarByImageManager exception", (Throwable)paramString);
    }
  }
  
  private final void b(BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject = paramBaseArticleInfo.getSubscribeUin();
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    do
    {
      ReadInJoyUserInfoModule localReadInJoyUserInfoModule;
      do
      {
        return;
        localReadInJoyUserInfoModule = qia.a();
      } while (localReadInJoyUserInfoModule == null);
      List localList = (List)new ArrayList();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "uin");
      localList.add(localObject);
      localObject = localReadInJoyUserInfoModule.a(localList, (qhl)new psd(this, paramBaseArticleInfo));
    } while (!(localObject instanceof ReadInJoyUserInfo));
    a((ReadInJoyUserInfo)localObject, paramBaseArticleInfo);
  }
  
  private final void c(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo.hasRequestFollowStatus) {
      return;
    }
    qfq.a(paramBaseArticleInfo.getSubscribeUin(), (qfs)new psc(paramBaseArticleInfo));
  }
  
  public void a(@NotNull BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseArticleInfo, "articleInfo");
    a(paramBaseArticleInfo);
    if (paramBaseArticleInfo.mSubArtilceList != null)
    {
      Object localObject = paramBaseArticleInfo.mSubArtilceList;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "articleInfo.mSubArtilceList");
      if (!((Collection)localObject).isEmpty()) {}
      for (paramInt = 1; paramInt != 0; paramInt = 0)
      {
        paramBaseArticleInfo = paramBaseArticleInfo.mSubArtilceList.iterator();
        while (paramBaseArticleInfo.hasNext())
        {
          localObject = (ArticleInfo)paramBaseArticleInfo.next();
          Intrinsics.checkExpressionValueIsNotNull(localObject, "info");
          a((BaseArticleInfo)localObject);
        }
      }
    }
  }
  
  public boolean a(@NotNull BaseArticleInfo paramBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseArticleInfo, "articleInfo");
    return pqw.v(paramBaseArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     psa
 * JD-Core Version:    0.7.0.1
 */