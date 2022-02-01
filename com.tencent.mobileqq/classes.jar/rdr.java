import com.tencent.biz.pubaccount.readinjoy.skin.BaseResData;
import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInjoySkinAndRefreshFacade.1;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.readinjoy.skin.SkinData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.GuideInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.RefreshInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.SkinInfo;

public class rdr
{
  private int jdField_a_of_type_Int;
  public AppInterface a;
  private String jdField_a_of_type_JavaLangString;
  private rdc jdField_a_of_type_Rdc = new rds(this);
  rdt jdField_a_of_type_Rdt;
  private boolean jdField_a_of_type_Boolean;
  
  public rdr(AppInterface paramAppInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  @Nullable
  private RefreshData a(int paramInt1, oidb_0x5bd.RefreshInfo paramRefreshInfo, int paramInt2)
  {
    rcx localrcx = (rcx)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(270);
    RefreshData localRefreshData;
    if (paramRefreshInfo.has())
    {
      paramRefreshInfo = new RefreshData(paramRefreshInfo);
      localRefreshData = localrcx.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), paramInt2);
      if (QLog.isColorLevel())
      {
        QLog.d("Q.readinjoy.4tab", 2, "onReqGuideInfo 5bd回包 ");
        if (paramRefreshInfo != null) {
          break label226;
        }
        QLog.d("Q.readinjoy.4tab", 2, "newRefreshData = " + paramRefreshInfo);
        label89:
        if (localRefreshData != null) {
          break label257;
        }
        QLog.d("Q.readinjoy.4tab", 2, "oldRefreshData = " + localRefreshData);
      }
      label120:
      if (paramRefreshInfo != null) {
        break label289;
      }
      if (localRefreshData != null)
      {
        bgsg.f(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), null, paramInt2);
        bgmg.b(rdv.a());
        localrcx.a(0, "", -1L, paramInt2);
      }
    }
    for (;;)
    {
      if (paramRefreshInfo != null)
      {
        paramRefreshInfo.setShowInSource(true, this.jdField_a_of_type_Int);
        if (localRefreshData != null) {
          paramRefreshInfo.isShown = localRefreshData.isShown;
        }
        bgsg.f(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramRefreshInfo.toJson().toString(), paramInt2);
      }
      return localRefreshData;
      paramRefreshInfo = null;
      break;
      label226:
      QLog.d("Q.readinjoy.4tab", 2, "newRefreshData = " + paramRefreshInfo.toString());
      break label89;
      label257:
      QLog.d("Q.readinjoy.4tab", 2, "oldRefreshData = " + localRefreshData.toString());
      break label120;
      label289:
      if (((localRefreshData == null) || (!paramRefreshInfo.id.equals(localRefreshData.id)) || (paramRefreshInfo.seq > localRefreshData.seq)) && (paramInt1 <= paramRefreshInfo.endTime))
      {
        bgmg.b(rdv.a());
        localrcx.a(paramRefreshInfo, this.jdField_a_of_type_Int);
      }
    }
  }
  
  private void a(int paramInt1, RefreshData paramRefreshData, oidb_0x5bd.SkinInfo paramSkinInfo, oidb_0x5bd.GuideInfo paramGuideInfo, int paramInt2)
  {
    Object localObject;
    if (paramSkinInfo.has())
    {
      paramSkinInfo = new SkinData(paramSkinInfo);
      localObject = new GuideData(paramGuideInfo, paramInt2);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.4tab", 2, "guideData = " + localObject);
      }
      paramGuideInfo = (rdd)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(261);
      if ((this.jdField_a_of_type_Boolean) || (paramInt1 < ((GuideData)localObject).beginTime) || (paramInt1 > ((GuideData)localObject).endTime)) {
        break label215;
      }
      a(261, "", (BaseResData)localObject);
      label112:
      localObject = paramGuideInfo.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication());
      if ((paramSkinInfo != null) || (paramGuideInfo.a() != 1)) {
        break label259;
      }
      this.jdField_a_of_type_JavaLangString = paramGuideInfo.a();
      bgsg.s(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), null);
      if ((paramRefreshData != null) && (paramInt1 <= paramRefreshData.endTime))
      {
        paramRefreshData.isShown = true;
        bgsg.f(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramRefreshData.toJson().toString(), paramInt2);
      }
    }
    label215:
    while ((paramSkinInfo == null) || (localObject == null) || (!((SkinData)localObject).id.equals(paramSkinInfo.id)) || (((SkinData)localObject).seq == paramSkinInfo.seq))
    {
      return;
      paramSkinInfo = null;
      break;
      if ((paramInt1 > ((GuideData)localObject).endTime) || (!bgnt.h(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication()))) {
        break label112;
      }
      paramGuideInfo.a((GuideData)localObject);
      paramGuideInfo.a(((GuideData)localObject).skinData);
      break label112;
    }
    label259:
    bgsg.s(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramSkinInfo.toJson().toString());
    if (paramSkinInfo.id.equals(paramGuideInfo.a()))
    {
      this.jdField_a_of_type_JavaLangString = paramSkinInfo.id;
      return;
    }
    bgmg.a(rcs.a(paramSkinInfo.id));
  }
  
  private void a(int paramInt, String paramString, BaseResData paramBaseResData)
  {
    if (this.jdField_a_of_type_Rdt != null) {
      this.jdField_a_of_type_Rdt.a(paramInt, paramString, paramBaseResData);
    }
  }
  
  private void a(int paramInt1, oidb_0x5bd.GuideInfo paramGuideInfo, int paramInt2)
  {
    rcw localrcw = (rcw)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(271);
    Object localObject;
    int i;
    if (paramGuideInfo.has())
    {
      paramGuideInfo = new GuideData(paramGuideInfo, paramInt2);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInjoySkinAndRefreshFacadeManager", 2, "guideData = " + paramGuideInfo);
      }
      localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory().createEntityManager();
      if (paramGuideInfo == null) {
        break label284;
      }
      paramGuideInfo.business = "operation_guide";
      GuideData localGuideData = (GuideData)((EntityManager)localObject).find(GuideData.class, new String[] { paramGuideInfo.id, paramGuideInfo.uin, paramGuideInfo.business });
      if ((localGuideData == null) || (localGuideData.showTime == 0)) {
        ((EntityManager)localObject).persistOrReplace(paramGuideInfo);
      }
      paramGuideInfo = localrcw.a("operation_guide", paramGuideInfo.id);
      if (paramGuideInfo == null) {
        return;
      }
      paramGuideInfo = paramGuideInfo.iterator();
      i = 0;
      label167:
      if (!paramGuideInfo.hasNext()) {
        return;
      }
      localObject = (GuideData)paramGuideInfo.next();
      if ((i != 0) || (((GuideData)localObject).source != paramInt2) || (paramInt1 < ((GuideData)localObject).beginTime) || (paramInt1 > ((GuideData)localObject).endTime)) {
        break label249;
      }
      a(271, "operation_guide", (BaseResData)localObject);
      this.jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      i += 1;
      break label167;
      paramGuideInfo = null;
      break;
      label249:
      if ((paramInt1 <= ((GuideData)localObject).endTime) && (bgnt.h(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication()))) {
        localrcw.c("operation_guide", (BaseResData)localObject);
      }
    }
    label284:
    localrcw.a(paramInt2);
  }
  
  public void a()
  {
    ThreadManager.post(new ReadInjoySkinAndRefreshFacade.1(this), 5, null, true);
  }
  
  public void a(rdt paramrdt)
  {
    this.jdField_a_of_type_Rdt = paramrdt;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Rdt = null;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_Rdc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rdr
 * JD-Core Version:    0.7.0.1
 */