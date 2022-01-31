import android.content.res.Resources;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.NearbyVideoUtils;
import com.tencent.mobileqq.nearby.business.NearbyCardObserver;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.HeadInfo;

public class paw
  extends NearbyCardObserver
{
  public paw(TroopMemberApiService paramTroopMemberApiService) {}
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberApiService", 2, "onDeleteNearbyPeopleAuthVideo isSuccess:" + paramBoolean);
    }
    ((NearbyCardManager)TroopMemberApiService.d(this.a).getManager(105)).d.put(((QQAppInterface)TroopMemberApiService.e(this.a)).getCurrentAccountUin(), Integer.valueOf(1));
    if (paramBoolean)
    {
      SharedPreUtils.a(BaseApplication.getContext(), false);
      QQToast.a(BaseApplication.getContext(), 2, "删除成功", 0).b(this.a.getResources().getDimensionPixelSize(2131558448));
      if (!paramBoolean) {
        break label157;
      }
    }
    label157:
    for (String str = "1";; str = "2")
    {
      NearbyVideoUtils.a("clk_del_video", new String[] { str });
      return;
      QQToast.a(BaseApplication.getContext(), 1, "删除失败", 0).b(this.a.getResources().getDimensionPixelSize(2131558448));
      break;
    }
  }
  
  protected void a(boolean paramBoolean, UpdatePhotoList.HeadInfo paramHeadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberApiService", 2, "onUpdateNearbyPeopleAuthVideo + HeadInfo = " + paramHeadInfo.toString());
    }
    ((NearbyCardManager)TroopMemberApiService.f(this.a).getManager(105)).d.put(((QQAppInterface)TroopMemberApiService.g(this.a)).getCurrentAccountUin(), Integer.valueOf(1));
    if (paramBoolean)
    {
      SharedPreUtils.a(BaseApplication.getContext(), true);
      QQToast.a(BaseApplication.getContext(), 2, "视频上传成功", 0).b(this.a.getResources().getDimensionPixelSize(2131558448));
      if (!paramBoolean) {
        break label160;
      }
    }
    label160:
    for (paramHeadInfo = "1";; paramHeadInfo = "2")
    {
      NearbyVideoUtils.a("clk_upload_video", new String[] { paramHeadInfo });
      return;
      QQToast.a(BaseApplication.getContext(), 1, "视频上传失败", 0).b(this.a.getResources().getDimensionPixelSize(2131558448));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     paw
 * JD-Core Version:    0.7.0.1
 */