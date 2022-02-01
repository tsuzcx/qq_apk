import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasCommentFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasCommentFragment.6.1;
import com.tencent.hippy.qq.module.tkd.TKDBiuModule.ParamsFetcher;
import com.tencent.hippy.qq.utils.tkd.TKDCommentDispatcher.HippyCommentEvent;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class pxt
  implements TKDCommentDispatcher.HippyCommentEvent
{
  public pxt(ReadInJoyAtlasCommentFragment paramReadInJoyAtlasCommentFragment) {}
  
  public void biuComment(@NotNull TKDBiuModule.ParamsFetcher paramParamsFetcher) {}
  
  public void closeComment()
  {
    ThreadManager.getUIHandler().post(new ReadInJoyAtlasCommentFragment.6.1(this));
  }
  
  public void jScloseComment() {}
  
  public void onClickLike(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4)
  {
    try
    {
      pvm.a().a(true, paramString1, paramString2, paramString3, "onCommentLike", Integer.parseInt(paramString4));
      return;
    }
    catch (NumberFormatException paramString1)
    {
      QLog.d(ReadInJoyAtlasCommentFragment.a(), 1, paramString1.getMessage());
    }
  }
  
  public void onCommentViewLayout() {}
  
  public void onCreateComment(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5, @NotNull String paramString6)
  {
    try
    {
      pvm.a().a(true, paramString1, paramString2, paramString3, Integer.parseInt(paramString4), "onCommentSend", Integer.parseInt(paramString5), paramString6);
      return;
    }
    catch (NumberFormatException paramString1)
    {
      QLog.d(ReadInJoyAtlasCommentFragment.a(), 1, paramString1.getMessage());
    }
  }
  
  public void onDeleteComment(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4)
  {
    try
    {
      pvm.a().a(true, paramString1, paramString2, "onCommentDelete", Integer.parseInt(paramString3), Integer.parseInt(paramString4));
      return;
    }
    catch (NumberFormatException paramString1)
    {
      QLog.d(ReadInJoyAtlasCommentFragment.a(), 1, paramString1.getMessage());
    }
  }
  
  public void onFontScaleChange(double paramDouble) {}
  
  public void onSubCommentClose() {}
  
  public void onSubCommentOpen() {}
  
  public void openComment() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pxt
 * JD-Core Version:    0.7.0.1
 */