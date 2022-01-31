import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.skin.BaseResData;
import com.tencent.biz.pubaccount.readinjoy.skin.CommonSkinRes;
import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyOperationManager;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyRefreshManager;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinManager;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshRes;
import com.tencent.biz.pubaccount.readinjoy.skin.SkinData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.GuideInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.RefreshInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.SkinInfo;

class lgc
  implements Runnable
{
  lgc(lgb paramlgb, oidb_0x5bd.GuideInfo paramGuideInfo1, oidb_0x5bd.RefreshInfo paramRefreshInfo, oidb_0x5bd.SkinInfo paramSkinInfo, oidb_0x5bd.GuideInfo paramGuideInfo2) {}
  
  public void run()
  {
    int j = (int)(System.currentTimeMillis() / 1000L);
    Object localObject2 = (ReadInJoyOperationManager)this.jdField_a_of_type_Lgb.a.app.getManager(270);
    Object localObject1;
    Object localObject3;
    Object localObject4;
    int i;
    if (this.jdField_a_of_type_TencentImOidbCmd0x5bdOidb_0x5bd$GuideInfo.has())
    {
      localObject1 = new GuideData(this.jdField_a_of_type_TencentImOidbCmd0x5bdOidb_0x5bd$GuideInfo);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNewFeedsActivity", 2, "guideData = " + localObject1);
      }
      localObject3 = this.jdField_a_of_type_Lgb.a.app.getEntityManagerFactory().createEntityManager();
      if (localObject1 == null) {
        break label306;
      }
      ((GuideData)localObject1).business = "operation_guide";
      localObject4 = (GuideData)((EntityManager)localObject3).a(GuideData.class, new String[] { ((GuideData)localObject1).id, ((GuideData)localObject1).uin, ((GuideData)localObject1).business });
      if ((localObject4 == null) || (((GuideData)localObject4).showTime == 0)) {
        ((EntityManager)localObject3).b((Entity)localObject1);
      }
      localObject1 = ((ReadInJoyOperationManager)localObject2).a("operation_guide");
      if (localObject1 == null) {
        break label314;
      }
      localObject1 = ((List)localObject1).iterator();
      i = 0;
      label188:
      if (!((Iterator)localObject1).hasNext()) {
        break label314;
      }
      localObject3 = (BaseResData)((Iterator)localObject1).next();
      if ((i != 0) || (j < ((BaseResData)localObject3).beginTime) || (j > ((BaseResData)localObject3).endTime)) {
        break label271;
      }
      this.jdField_a_of_type_Lgb.a.a(270, "operation_guide", (BaseResData)localObject3);
      ReadInJoyNewFeedsActivity.a(this.jdField_a_of_type_Lgb.a, true);
    }
    for (;;)
    {
      i += 1;
      break label188;
      localObject1 = null;
      break;
      label271:
      if ((j <= ((BaseResData)localObject3).endTime) && (NetworkUtil.h(this.jdField_a_of_type_Lgb.a))) {
        ((ReadInJoyOperationManager)localObject2).a("operation_guide", (BaseResData)localObject3);
      }
    }
    label306:
    ((EntityManager)localObject3).a(GuideData.class);
    label314:
    localObject2 = (ReadInJoyRefreshManager)this.jdField_a_of_type_Lgb.a.app.getManager(269);
    if (this.jdField_a_of_type_TencentImOidbCmd0x5bdOidb_0x5bd$RefreshInfo.has())
    {
      localObject1 = new RefreshData(this.jdField_a_of_type_TencentImOidbCmd0x5bdOidb_0x5bd$RefreshInfo);
      localObject3 = ((ReadInJoyRefreshManager)localObject2).a(this.jdField_a_of_type_Lgb.a);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNewFeedsActivity", 2, "newRefreshData = " + localObject1);
      }
      if (localObject1 != null) {
        break label716;
      }
      if (localObject3 != null)
      {
        SharedPreUtils.v(this.jdField_a_of_type_Lgb.a, this.jdField_a_of_type_Lgb.a.app.getCurrentAccountUin(), null);
        FileUtils.b(RefreshRes.a());
        ((ReadInJoyRefreshManager)localObject2).a(0, "");
      }
      if ((localObject3 != null) && (j <= ((RefreshData)localObject3).endTime))
      {
        ((RefreshData)localObject3).isShown = true;
        SharedPreUtils.v(this.jdField_a_of_type_Lgb.a.getActivity(), this.jdField_a_of_type_Lgb.a.app.getCurrentAccountUin(), ((RefreshData)localObject3).toJson().toString());
      }
      label503:
      localObject2 = (ReadInJoySkinManager)this.jdField_a_of_type_Lgb.a.app.getManager(260);
      if (!this.jdField_a_of_type_TencentImOidbCmd0x5bdOidb_0x5bd$SkinInfo.has()) {
        break label788;
      }
      localObject1 = new SkinData(this.jdField_a_of_type_TencentImOidbCmd0x5bdOidb_0x5bd$SkinInfo);
      label546:
      localObject3 = new GuideData(this.b);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNewFeedsActivity", 2, "guideData = " + localObject3);
      }
      if ((ReadInJoyNewFeedsActivity.a(this.jdField_a_of_type_Lgb.a)) || (localObject3 == null) || (j < ((GuideData)localObject3).beginTime) || (j > ((GuideData)localObject3).endTime)) {
        break label793;
      }
      this.jdField_a_of_type_Lgb.a.a(260, "", (BaseResData)localObject3);
      label644:
      localObject4 = ((ReadInJoySkinManager)localObject2).a(this.jdField_a_of_type_Lgb.a);
      if ((localObject1 != null) || (((ReadInJoySkinManager)localObject2).a() != 1)) {
        break label842;
      }
      this.jdField_a_of_type_Lgb.a.a = ((ReadInJoySkinManager)localObject2).a();
      SharedPreUtils.u(this.jdField_a_of_type_Lgb.a, this.jdField_a_of_type_Lgb.a.app.getCurrentAccountUin(), null);
    }
    label716:
    while ((localObject1 == null) || (localObject4 == null) || (!((SkinData)localObject4).id.equals(((SkinData)localObject1).id)) || (((SkinData)localObject4).seq == ((SkinData)localObject1).seq))
    {
      return;
      localObject1 = null;
      break;
      if (((localObject3 != null) && (((RefreshData)localObject1).id.equals(((RefreshData)localObject3).id)) && ((!((RefreshData)localObject1).id.equals(((RefreshData)localObject3).id)) || (((RefreshData)localObject1).seq <= ((RefreshData)localObject3).seq))) || (j > ((RefreshData)localObject1).endTime)) {
        break label503;
      }
      FileUtils.b(RefreshRes.a());
      ((ReadInJoyRefreshManager)localObject2).a((RefreshData)localObject1);
      break label503;
      localObject1 = null;
      break label546;
      if ((localObject3 == null) || (j > ((GuideData)localObject3).endTime) || (!NetworkUtil.h(this.jdField_a_of_type_Lgb.a))) {
        break label644;
      }
      ((ReadInJoySkinManager)localObject2).a((GuideData)localObject3);
      ((ReadInJoySkinManager)localObject2).a(((GuideData)localObject3).skinData);
      break label644;
    }
    label788:
    label793:
    label842:
    SharedPreUtils.u(this.jdField_a_of_type_Lgb.a, this.jdField_a_of_type_Lgb.a.app.getCurrentAccountUin(), ((GuideData)localObject3).skinData.toJson().toString());
    if (((SkinData)localObject1).id.equals(((ReadInJoySkinManager)localObject2).a()))
    {
      this.jdField_a_of_type_Lgb.a.a = ((SkinData)localObject1).id;
      return;
    }
    FileUtils.a(CommonSkinRes.a(((SkinData)localObject1).id));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lgc
 * JD-Core Version:    0.7.0.1
 */