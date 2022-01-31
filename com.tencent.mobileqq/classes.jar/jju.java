import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.GuildInfo;
import com.tencent.av.guild.GuildMultiActivity;
import com.tencent.av.utils.AvAddFriendHelper;
import com.tencent.av.widget.stageview.StageEffectView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class jju
  extends GAudioUIObserver
{
  public jju(GuildMultiActivity paramGuildMultiActivity) {}
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(GuildMultiActivity.jdField_a_of_type_JavaLangString, 2, "finishActivity isQuit" + paramBoolean);
    }
    if (paramBoolean)
    {
      GuildMultiActivity.a(this.a);
      return;
    }
    this.a.finish();
  }
  
  protected void a()
  {
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (!this.a.b))
    {
      if (QLog.isColorLevel()) {
        QLog.e(GuildMultiActivity.jdField_a_of_type_JavaLangString, 2, "onServiceConnected");
      }
      this.a.jdField_a_of_type_ComTencentAvVideoController.a(this.a.c);
    }
  }
  
  protected void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(GuildMultiActivity.jdField_a_of_type_JavaLangString, 2, "onCreateOrEnterRoomFail-->GroupID=" + paramLong + ", reason" + paramInt1);
    }
    if ((-19 == paramInt2) || (19 == paramInt2))
    {
      this.a.a(true);
      return;
    }
    this.a.a(false);
  }
  
  protected void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (SessionMgr.a().a(this.a.e).a.a != paramLong1)
    {
      if (QLog.isColorLevel()) {
        QLog.e(GuildMultiActivity.jdField_a_of_type_JavaLangString, 2, "onMemberJoin,wrong group uin.GroupUin=" + paramLong1 + " mGroupId=" + SessionMgr.a().a(this.a.e).a.a);
      }
      return;
    }
    super.a(paramLong1, paramLong2, paramBoolean);
    this.a.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramLong2));
    this.a.a(paramLong2);
    this.a.g();
  }
  
  protected void a(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramLong1, paramLong2, paramBoolean1, paramBoolean2);
    if (QLog.isColorLevel()) {
      QLog.d(GuildMultiActivity.jdField_a_of_type_JavaLangString, 2, "onMemberJoin friendUin" + paramLong2 + " isRefresh=" + paramBoolean1);
    }
    Object localObject = String.valueOf(paramLong2);
    if (TextUtils.equals(this.a.c, (CharSequence)localObject)) {
      ReportController.b(null, "CliOper", "", "", "0X80057E8", "0X80057E8", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject);
      if (localObject != null) {
        ((VideoController.GAudioFriends)localObject).b = SystemClock.elapsedRealtime();
      }
      if (SessionMgr.a().a(this.a.e).a.a == paramLong1) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e(GuildMultiActivity.jdField_a_of_type_JavaLangString, 2, "onMemberJoin,wrong group uin.GroupUin=" + paramLong1 + " mCurrGroupId=" + SessionMgr.a().a(this.a.e).a.a);
      }
      return;
      this.a.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.b((String)localObject);
    }
    GuildMultiActivity.a(this.a, true);
    this.a.g();
  }
  
  protected void a(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(GuildMultiActivity.jdField_a_of_type_JavaLangString, 2, "onDestroyRandomChat");
    }
    if (SessionMgr.a().a(this.a.e) == null) {}
    do
    {
      return;
      super.c(paramLong);
    } while ((SessionMgr.a().a(this.a.e).a.a != 0L) && (SessionMgr.a().a(this.a.e).a.a != paramLong));
    b(paramBoolean);
  }
  
  protected void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramLong, paramBoolean1, paramBoolean2);
    if ((!GuildMultiActivity.a(this.a, String.valueOf(paramLong))) || (this.a.jdField_a_of_type_ComTencentAvVideoController.d != 3)) {
      this.a.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView.a(String.valueOf(paramLong), paramBoolean1);
    }
  }
  
  protected void b(long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(GuildMultiActivity.jdField_a_of_type_JavaLangString, 2, "onGroupVideoChatClosed" + paramInt1);
    }
    GuildMultiActivity.a(this.a);
  }
  
  protected void c(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(GuildMultiActivity.jdField_a_of_type_JavaLangString, 2, "onDestroyUI");
    }
    if (SessionMgr.a().a(this.a.e) == null) {
      if (this.a.d) {
        b(true);
      }
    }
    do
    {
      return;
      this.a.finish();
      return;
      super.c(paramLong);
    } while ((SessionMgr.a().a(this.a.e).a.a != 0L) && (SessionMgr.a().a(this.a.e).a.a != paramLong));
    b(true);
    this.a.jdField_a_of_type_JavaUtilHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jju
 * JD-Core Version:    0.7.0.1
 */