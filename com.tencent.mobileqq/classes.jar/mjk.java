import com.tencent.biz.pubaccount.readinjoy.skin.BaseResData;
import com.tencent.biz.pubaccount.readinjoy.skin.CommonSkinRes;
import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyOperationManager;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyRefreshManager;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinManager;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshRes;
import com.tencent.biz.pubaccount.readinjoy.skin.SkinData;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
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

class mjk
  implements Runnable
{
  mjk(mjj parammjj, oidb_0x5bd.GuideInfo paramGuideInfo1, oidb_0x5bd.RefreshInfo paramRefreshInfo, oidb_0x5bd.SkinInfo paramSkinInfo, oidb_0x5bd.GuideInfo paramGuideInfo2) {}
  
  public void run()
  {
    int j = (int)(System.currentTimeMillis() / 1000L);
    Object localObject2 = (ReadInJoyOperationManager)this.jdField_a_of_type_Mjj.a.a.getManager(270);
    Object localObject1;
    Object localObject4;
    int i;
    if (this.jdField_a_of_type_TencentImOidbCmd0x5bdOidb_0x5bd$GuideInfo.has())
    {
      localObject1 = new GuideData(this.jdField_a_of_type_TencentImOidbCmd0x5bdOidb_0x5bd$GuideInfo);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyTabFrame", 2, "guideData = " + localObject1);
      }
      localObject3 = this.jdField_a_of_type_Mjj.a.a.getEntityManagerFactory().createEntityManager();
      if (localObject1 == null) {
        break label309;
      }
      ((GuideData)localObject1).business = "operation_guide";
      localObject4 = (GuideData)((EntityManager)localObject3).a(GuideData.class, new String[] { ((GuideData)localObject1).id, ((GuideData)localObject1).uin, ((GuideData)localObject1).business });
      if ((localObject4 == null) || (((GuideData)localObject4).showTime == 0)) {
        ((EntityManager)localObject3).b((Entity)localObject1);
      }
      localObject1 = ((ReadInJoyOperationManager)localObject2).a("operation_guide");
      if (localObject1 == null) {
        break label317;
      }
      localObject1 = ((List)localObject1).iterator();
      i = 0;
      label188:
      if (!((Iterator)localObject1).hasNext()) {
        break label317;
      }
      localObject3 = (BaseResData)((Iterator)localObject1).next();
      if ((i != 0) || (j < ((BaseResData)localObject3).beginTime) || (j > ((BaseResData)localObject3).endTime)) {
        break label271;
      }
      this.jdField_a_of_type_Mjj.a.a(270, "operation_guide", (BaseResData)localObject3);
      ReadinjoyTabFrame.b(this.jdField_a_of_type_Mjj.a, true);
    }
    for (;;)
    {
      i += 1;
      break label188;
      localObject1 = null;
      break;
      label271:
      if ((j <= ((BaseResData)localObject3).endTime) && (NetworkUtil.h(this.jdField_a_of_type_Mjj.a.a()))) {
        ((ReadInJoyOperationManager)localObject2).a("operation_guide", (BaseResData)localObject3);
      }
    }
    label309:
    ((EntityManager)localObject3).a(GuideData.class);
    label317:
    Object localObject3 = (ReadInJoyRefreshManager)this.jdField_a_of_type_Mjj.a.a.getManager(269);
    if (this.jdField_a_of_type_TencentImOidbCmd0x5bdOidb_0x5bd$RefreshInfo.has())
    {
      localObject1 = new RefreshData(this.jdField_a_of_type_TencentImOidbCmd0x5bdOidb_0x5bd$RefreshInfo);
      localObject2 = ((ReadInJoyRefreshManager)localObject3).a(this.jdField_a_of_type_Mjj.a.a());
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.4tab", 2, "newRefreshData = " + localObject1);
      }
      if (localObject1 != null) {
        break label732;
      }
      if (localObject2 != null)
      {
        SharedPreUtils.v(this.jdField_a_of_type_Mjj.a.a(), this.jdField_a_of_type_Mjj.a.a.getCurrentAccountUin(), null);
        FileUtils.b(RefreshRes.a());
        ((ReadInJoyRefreshManager)localObject3).a(0, "");
      }
      label458:
      if (!this.jdField_a_of_type_TencentImOidbCmd0x5bdOidb_0x5bd$SkinInfo.has()) {
        break label804;
      }
      localObject1 = new SkinData(this.jdField_a_of_type_TencentImOidbCmd0x5bdOidb_0x5bd$SkinInfo);
      label480:
      localObject4 = new GuideData(this.b);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.4tab", 2, "guideData = " + localObject4);
      }
      localObject3 = (ReadInJoySkinManager)this.jdField_a_of_type_Mjj.a.a.getManager(260);
      if ((ReadinjoyTabFrame.a(this.jdField_a_of_type_Mjj.a)) || (localObject4 == null) || (j < ((GuideData)localObject4).beginTime) || (j > ((GuideData)localObject4).endTime)) {
        break label809;
      }
      this.jdField_a_of_type_Mjj.a.a(260, "", (BaseResData)localObject4);
      label599:
      localObject4 = ((ReadInJoySkinManager)localObject3).a(this.jdField_a_of_type_Mjj.a.a());
      if ((localObject1 != null) || (((ReadInJoySkinManager)localObject3).a() != 1)) {
        break label861;
      }
      ReadinjoyTabFrame.a(this.jdField_a_of_type_Mjj.a, ((ReadInJoySkinManager)localObject3).a());
      SharedPreUtils.u(this.jdField_a_of_type_Mjj.a.a(), this.jdField_a_of_type_Mjj.a.a.getCurrentAccountUin(), null);
      if ((localObject2 != null) && (j <= ((RefreshData)localObject2).endTime))
      {
        ((RefreshData)localObject2).isShown = true;
        SharedPreUtils.v(this.jdField_a_of_type_Mjj.a.a(), this.jdField_a_of_type_Mjj.a.a.getCurrentAccountUin(), ((RefreshData)localObject2).toJson().toString());
      }
    }
    label732:
    label861:
    while ((localObject1 == null) || (localObject4 == null) || (!((SkinData)localObject4).id.equals(((SkinData)localObject1).id)) || (((SkinData)localObject4).seq == ((SkinData)localObject1).seq))
    {
      return;
      localObject1 = null;
      break;
      if (((localObject2 != null) && (((RefreshData)localObject1).id.equals(((RefreshData)localObject2).id)) && ((!((RefreshData)localObject1).id.equals(((RefreshData)localObject2).id)) || (((RefreshData)localObject1).seq <= ((RefreshData)localObject2).seq))) || (j > ((RefreshData)localObject1).endTime)) {
        break label458;
      }
      FileUtils.b(RefreshRes.a());
      ((ReadInJoyRefreshManager)localObject3).a((RefreshData)localObject1);
      break label458;
      localObject1 = null;
      break label480;
      if ((localObject4 == null) || (j > ((GuideData)localObject4).endTime) || (!NetworkUtil.h(this.jdField_a_of_type_Mjj.a.a()))) {
        break label599;
      }
      ((ReadInJoySkinManager)localObject3).a((GuideData)localObject4);
      ((ReadInJoySkinManager)localObject3).a(((GuideData)localObject4).skinData);
      break label599;
    }
    label804:
    label809:
    SharedPreUtils.u(this.jdField_a_of_type_Mjj.a.a(), this.jdField_a_of_type_Mjj.a.a.getCurrentAccountUin(), ((SkinData)localObject1).toJson().toString());
    if (((SkinData)localObject1).id.equals(((ReadInJoySkinManager)localObject3).a()))
    {
      ReadinjoyTabFrame.a(this.jdField_a_of_type_Mjj.a, ((SkinData)localObject1).id);
      return;
    }
    FileUtils.a(CommonSkinRes.a(((SkinData)localObject1).id));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mjk
 * JD-Core Version:    0.7.0.1
 */