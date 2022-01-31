import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJSkinOperationPopupStep.1;
import com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJSkinOperationPopupStep.2;
import com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJSkinOperationPopupStep.6;
import com.tencent.biz.pubaccount.readinjoy.skin.BaseResData;
import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.readinjoy.skin.SkinData;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySkinGuideView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.GuideInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.RefreshInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.SkinInfo;

public class oym
  extends oyf
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  @Nullable
  private ReadInJoySkinGuideView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView;
  @Nullable
  private String jdField_a_of_type_JavaLangString;
  private oxe jdField_a_of_type_Oxe = new oyq(this);
  private qiz jdField_a_of_type_Qiz = new oyp(this);
  private boolean jdField_a_of_type_Boolean;
  
  public oym(@NotNull oyg paramoyg, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    super(paramoyg, "RIJSkinOperationPopupStep");
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  @UiThread
  private void a(GuideData paramGuideData, String paramString, int paramInt)
  {
    if (!a()) {}
    FrameLayout localFrameLayout;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView != null);
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localFrameLayout = (FrameLayout)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131364773);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView = new ReadInJoySkinGuideView(0, this.jdField_a_of_type_AndroidAppActivity, localQQAppInterface, paramGuideData.id, paramString, paramInt, new oyn(this, localFrameLayout, paramInt, localQQAppInterface), new oyo(this, localQQAppInterface, paramGuideData, localFrameLayout));
    } while (a() != 0);
    localFrameLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView, -1, -1);
  }
  
  private void a(oidb_0x5bd.GuideInfo paramGuideInfo1, int paramInt, oidb_0x5bd.RefreshInfo paramRefreshInfo, oidb_0x5bd.SkinInfo paramSkinInfo, oidb_0x5bd.GuideInfo paramGuideInfo2)
  {
    boolean bool1 = a(paramGuideInfo1, paramInt);
    a(paramRefreshInfo, paramInt);
    boolean bool2 = a(paramInt, paramSkinInfo, paramGuideInfo2);
    ThreadManager.getUIHandler().post(new RIJSkinOperationPopupStep.6(this, bool1 | bool2));
  }
  
  private void a(oidb_0x5bd.RefreshInfo paramRefreshInfo, int paramInt)
  {
    int i = (int)(System.currentTimeMillis() / 1000L);
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    qiu localqiu = (qiu)localQQAppInterface.getManager(270);
    RefreshData localRefreshData;
    if (paramRefreshInfo.has())
    {
      paramRefreshInfo = new RefreshData(paramRefreshInfo);
      localRefreshData = localqiu.a(this.jdField_a_of_type_AndroidAppActivity, paramInt);
      if (QLog.isColorLevel())
      {
        QLog.d("Q.readinjoy.4tab", 2, "onReqGuideInfo 5bd回包 ");
        if (paramRefreshInfo != null) {
          break label225;
        }
        QLog.d("Q.readinjoy.4tab", 2, "newRefreshData = " + paramRefreshInfo);
        label104:
        if (localRefreshData != null) {
          break label256;
        }
        QLog.d("Q.readinjoy.4tab", 2, "oldRefreshData = " + localRefreshData);
      }
      label135:
      if (paramRefreshInfo != null) {
        break label288;
      }
      if (localRefreshData != null)
      {
        bdiv.f(this.jdField_a_of_type_AndroidAppActivity, localQQAppInterface.getCurrentAccountUin(), null, paramInt);
        bdcs.b(qjs.a());
        localqiu.a(0, "", -1L, paramInt);
      }
    }
    for (;;)
    {
      if (paramRefreshInfo != null)
      {
        paramRefreshInfo.showInFeeds = true;
        if (localRefreshData != null) {
          paramRefreshInfo.isShown = localRefreshData.isShown;
        }
        bdiv.f(this.jdField_a_of_type_AndroidAppActivity, localQQAppInterface.getCurrentAccountUin(), paramRefreshInfo.toJson().toString(), paramInt);
      }
      return;
      paramRefreshInfo = null;
      break;
      label225:
      QLog.d("Q.readinjoy.4tab", 2, "newRefreshData = " + paramRefreshInfo.toString());
      break label104;
      label256:
      QLog.d("Q.readinjoy.4tab", 2, "oldRefreshData = " + localRefreshData.toString());
      break label135;
      label288:
      if (((localRefreshData == null) || (!paramRefreshInfo.id.equals(localRefreshData.id)) || (paramRefreshInfo.seq > localRefreshData.seq)) && (i <= paramRefreshInfo.endTime))
      {
        localqiu.a(0, "", -1L, paramInt);
        bdcs.b(qjs.a());
        localqiu.a(paramRefreshInfo, paramInt);
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.4tab", 2, "setRefreshType none and downloadRefreshRes");
        }
      }
    }
  }
  
  private boolean a(int paramInt, String paramString, BaseResData paramBaseResData)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    qir localqir = (qir)localQQAppInterface.getManager(paramInt);
    if (localqir.a(paramString, paramBaseResData))
    {
      String str = localqir.b(paramString, paramBaseResData.id);
      if (localqir.b(paramString, paramBaseResData))
      {
        if (261 == paramInt)
        {
          if (bdiv.g(this.jdField_a_of_type_AndroidAppActivity, paramBaseResData.id) != paramBaseResData.seq)
          {
            bdcs.a(str);
            localqir.c(paramString, paramBaseResData);
            return false;
          }
          bdiv.t(this.jdField_a_of_type_AndroidAppActivity, localQQAppInterface.getCurrentAccountUin(), paramBaseResData.id);
          bdiv.C(this.jdField_a_of_type_AndroidAppActivity, localQQAppInterface.getCurrentAccountUin());
        }
        localqir.b(paramString, paramBaseResData);
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.4tab", 2, "checkAndSkinGuide：real: " + paramBaseResData.id);
        }
        if ((paramBaseResData instanceof GuideData))
        {
          paramString = (GuideData)paramBaseResData;
          ThreadManager.getUIHandler().post(new RIJSkinOperationPopupStep.2(this, paramString, str, paramInt));
          return true;
        }
      }
      else
      {
        localqir.c(paramString, paramBaseResData);
      }
    }
    return false;
  }
  
  private boolean a(int paramInt, oidb_0x5bd.SkinInfo paramSkinInfo, oidb_0x5bd.GuideInfo paramGuideInfo)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    boolean bool2 = false;
    RefreshData localRefreshData = ((qiu)localQQAppInterface.getManager(270)).a(this.jdField_a_of_type_AndroidAppActivity, paramInt);
    int i = (int)(System.currentTimeMillis() / 1000L);
    Object localObject;
    boolean bool1;
    if (paramSkinInfo.has())
    {
      paramSkinInfo = new SkinData(paramSkinInfo);
      localObject = new GuideData(paramGuideInfo, paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.4tab", 2, "guideData = " + localObject);
      }
      paramGuideInfo = (qja)localQQAppInterface.getManager(261);
      if ((this.jdField_a_of_type_Boolean) || (i < ((GuideData)localObject).beginTime) || (i > ((GuideData)localObject).endTime)) {
        break label258;
      }
      bool1 = bool2;
      if (a(261, "", (BaseResData)localObject)) {
        bool1 = true;
      }
      label165:
      localObject = paramGuideInfo.a(this.jdField_a_of_type_AndroidAppActivity);
      if ((paramSkinInfo != null) || (paramGuideInfo.a() != 1)) {
        break label310;
      }
      this.jdField_a_of_type_JavaLangString = paramGuideInfo.a();
      bdiv.s(this.jdField_a_of_type_AndroidAppActivity, localQQAppInterface.getCurrentAccountUin(), null);
      if ((localRefreshData != null) && (i <= localRefreshData.endTime))
      {
        localRefreshData.isShown = true;
        bdiv.f(this.jdField_a_of_type_AndroidAppActivity, localQQAppInterface.getCurrentAccountUin(), localRefreshData.toJson().toString(), paramInt);
      }
    }
    label258:
    label310:
    while ((paramSkinInfo == null) || (localObject == null) || (!((SkinData)localObject).id.equals(paramSkinInfo.id)) || (((SkinData)localObject).seq == paramSkinInfo.seq))
    {
      return bool1;
      paramSkinInfo = null;
      break;
      bool1 = bool2;
      if (i > ((GuideData)localObject).endTime) {
        break label165;
      }
      bool1 = bool2;
      if (!bdee.h(this.jdField_a_of_type_AndroidAppActivity)) {
        break label165;
      }
      paramGuideInfo.a((GuideData)localObject);
      paramGuideInfo.a(((GuideData)localObject).skinData);
      bool1 = bool2;
      break label165;
    }
    bdiv.s(this.jdField_a_of_type_AndroidAppActivity, localQQAppInterface.getCurrentAccountUin(), paramSkinInfo.toJson().toString());
    if (paramSkinInfo.id.equals(paramGuideInfo.a()))
    {
      this.jdField_a_of_type_JavaLangString = paramSkinInfo.id;
      return bool1;
    }
    bdcs.a(qip.a(paramSkinInfo.id));
    return bool1;
  }
  
  private boolean a(oidb_0x5bd.GuideInfo paramGuideInfo, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    int j = (int)(System.currentTimeMillis() / 1000L);
    qit localqit = (qit)((QQAppInterface)localObject).getManager(271);
    int i;
    if (paramGuideInfo.has())
    {
      paramGuideInfo = new GuideData(paramGuideInfo, paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("RIJSkinOperationPopupStep", 2, "guideData = " + paramGuideInfo);
      }
      localObject = ((QQAppInterface)localObject).getEntityManagerFactory().createEntityManager();
      if (paramGuideInfo == null) {
        break label338;
      }
      paramGuideInfo.business = "operation_guide";
      GuideData localGuideData = (GuideData)((awbw)localObject).a(GuideData.class, new String[] { paramGuideInfo.id, paramGuideInfo.uin, paramGuideInfo.business });
      if ((localGuideData == null) || (localGuideData.showTime == 0)) {
        ((awbw)localObject).b(paramGuideInfo);
      }
      paramGuideInfo = localqit.a("operation_guide", paramGuideInfo.id);
      if (paramGuideInfo == null) {
        break label345;
      }
      paramGuideInfo = paramGuideInfo.iterator();
      i = 0;
      label192:
      bool2 = bool1;
      if (!paramGuideInfo.hasNext()) {
        break label345;
      }
      localObject = (GuideData)paramGuideInfo.next();
      if ((i != 0) || (((GuideData)localObject).source != paramInt) || (j < ((GuideData)localObject).beginTime) || (j > ((GuideData)localObject).endTime)) {
        break label292;
      }
      if (a(271, "operation_guide", (BaseResData)localObject)) {
        bool1 = true;
      }
      this.jdField_a_of_type_Boolean = true;
      bool2 = bool1;
    }
    for (;;)
    {
      i += 1;
      bool1 = bool2;
      break label192;
      paramGuideInfo = null;
      break;
      label292:
      bool2 = bool1;
      if (j <= ((GuideData)localObject).endTime)
      {
        bool2 = bool1;
        if (bdee.h(this.jdField_a_of_type_AndroidAppActivity))
        {
          localqit.c("operation_guide", (BaseResData)localObject);
          bool2 = bool1;
        }
      }
    }
    label338:
    localqit.a(paramInt);
    label345:
    return bool2;
  }
  
  private void i()
  {
    ThreadManager.excute(new RIJSkinOperationPopupStep.1(this), 16, null, true);
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView.a();
      ((FrameLayout)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131364773)).removeView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView = null;
    }
  }
  
  public int a()
  {
    return 0;
  }
  
  public void a()
  {
    super.a();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    localQQAppInterface.addObserver(this.jdField_a_of_type_Qiz);
    localQQAppInterface.addObserver(this.jdField_a_of_type_Oxe);
  }
  
  public void b()
  {
    super.b();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    localQQAppInterface.removeObserver(this.jdField_a_of_type_Qiz);
    localQQAppInterface.removeObserver(this.jdField_a_of_type_Oxe);
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      bdcs.a(qip.a(this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_JavaLangString = null;
    }
  }
  
  protected void g() {}
  
  protected void h()
  {
    i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oym
 * JD-Core Version:    0.7.0.1
 */