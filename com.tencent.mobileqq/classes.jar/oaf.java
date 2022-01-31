import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.DiscoverManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.request.square.GetSquareBannerRequest;
import com.tencent.biz.qqstory.network.request.square.GetSquareBannerRequest.GetSquareBannerResponse;
import com.tencent.biz.qqstory.storyHome.square.SquareFeedListPageLoader;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.List;

public class oaf
  implements CmdTaskManger.CommandCallback
{
  public oaf(SquareFeedListPageLoader paramSquareFeedListPageLoader) {}
  
  public void a(@NonNull GetSquareBannerRequest arg1, @Nullable GetSquareBannerRequest.GetSquareBannerResponse paramGetSquareBannerResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    ??? = (DiscoverManager)SuperManager.a(22);
    if ((paramErrorMessage.isSuccess()) && (paramGetSquareBannerResponse != null))
    {
      ???.b(paramGetSquareBannerResponse.a, true);
      SLog.a("Q.qqstory.discover.SquareFeedListPageLoader", "refresh banner :%s", paramGetSquareBannerResponse.a);
      synchronized (this.a)
      {
        SquareFeedListPageLoader.a(this.a, paramGetSquareBannerResponse);
        SquareFeedListPageLoader.a(this.a);
        return;
      }
    }
    SLog.b("Q.qqstory.discover.SquareFeedListPageLoader", "refresh banner fail:%s", paramErrorMessage);
    paramGetSquareBannerResponse = ???.b();
    for (;;)
    {
      synchronized (this.a)
      {
        if (paramGetSquareBannerResponse.size() > 0)
        {
          SquareFeedListPageLoader.a(this.a, new GetSquareBannerRequest.GetSquareBannerResponse(new ErrorMessage()));
          SquareFeedListPageLoader.a(this.a).a = paramGetSquareBannerResponse;
          SquareFeedListPageLoader.a(this.a);
          return;
        }
      }
      SquareFeedListPageLoader.a(this.a, new GetSquareBannerRequest.GetSquareBannerResponse(paramErrorMessage));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oaf
 * JD-Core Version:    0.7.0.1
 */