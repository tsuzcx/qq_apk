package cooperation.qzone.contentbox;

import alud;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import bdhk;
import bdib;
import bdnn;
import bflz;
import bhtv;
import bjdt;
import bjhn;
import bjho;
import bjis;
import bjit;
import bjiu;
import bjiv;
import bjiw;
import bjix;
import bjiy;
import bjjd;
import bjje;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import common.config.service.QzoneConfig;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.contentbox.model.MQMsg;
import cooperation.qzone.contentbox.model.MQMsgBody;
import cooperation.qzone.contentbox.model.MQPhotoCell;
import cooperation.qzone.contentbox.model.QZoneMsgEntityNew;
import cooperation.qzone.provider.LocalPhotoGroupData;
import cooperation.qzone.report.lp.LpReportInfo_dc02880;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.report.lp.QZoneLoginReportHelper;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.util.ArrayList;
import java.util.Iterator;

public class QZoneMsgFragment
  extends Fragment
  implements Handler.Callback, bjit
{
  protected int a;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new bjiu(this);
  private Handler jdField_a_of_type_AndroidOsHandler;
  private final bhtv jdField_a_of_type_Bhtv = new bjiv(this);
  private bjhn jdField_a_of_type_Bjhn;
  public bjis a;
  bjix jdField_a_of_type_Bjix;
  bjje jdField_a_of_type_Bjje = new bjiw(this);
  public volatile QQAppInterface a;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private FootNavigationLayout jdField_a_of_type_CooperationQzoneContentboxFootNavigationLayout;
  private LocalPhotoGroupData jdField_a_of_type_CooperationQzoneProviderLocalPhotoGroupData;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private volatile boolean d;
  private volatile boolean e = true;
  private boolean f;
  
  public QZoneMsgFragment()
  {
    this.jdField_a_of_type_Int = 5;
  }
  
  private MQMsg a()
  {
    if (this.jdField_a_of_type_Bjis == null)
    {
      QLog.d("QZoneMsgManager.QZoneMsgFragment", 2, "getLastMQMsg failed: adapter == null");
      return null;
    }
    return this.jdField_a_of_type_Bjis.a();
  }
  
  private void a()
  {
    ThreadManagerV2.excute(new QZoneMsgFragment.3(this), 32, null, true);
  }
  
  private void a(View paramView) {}
  
  private void a(QZoneMsgEntityNew paramQZoneMsgEntityNew)
  {
    if (paramQZoneMsgEntityNew == null)
    {
      paramQZoneMsgEntityNew = new ArrayList();
      paramQZoneMsgEntityNew.add(new bjjd(alud.a(2131720579), "mqqzone://arouse/activefeed"));
      paramQZoneMsgEntityNew.add(new bjjd(alud.a(2131712416), "mqqzone://arouse/albumlist"));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.post(new QZoneMsgFragment.6(this, paramQZoneMsgEntityNew));
      }
      return;
      paramQZoneMsgEntityNew = paramQZoneMsgEntityNew.bottomItems;
    }
  }
  
  private void a(boolean paramBoolean) {}
  
  private boolean a()
  {
    if (this.jdField_a_of_type_Bjis == null)
    {
      QLog.d("QZoneMsgManager.QZoneMsgFragment", 2, "removeLastEmptyMQMsg failed: adapter == null");
      return false;
    }
    return this.jdField_a_of_type_Bjis.a();
  }
  
  private void b()
  {
    this.jdField_b_of_type_Int = 2;
    ((bjiy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(293)).b();
    if (QLog.isColorLevel()) {
      QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "refresh ，requestState=" + this.jdField_b_of_type_Int);
    }
  }
  
  private void b(String paramString)
  {
    ThreadManager.postImmediately(new QZoneMsgFragment.4(this, paramString), null, false);
  }
  
  private void b(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.f)) {
      bflz.a().a(alud.a(2131712420));
    }
    d(paramBoolean);
    this.jdField_b_of_type_Int = 0;
    if (QLog.isColorLevel()) {
      QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "loadMoreFinish ，requestState=" + this.jdField_b_of_type_Int);
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentWidgetListView == null) {}
    int k;
    do
    {
      return;
      k = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
    } while (k <= 0);
    int j = 0;
    int i = 0;
    label24:
    Object localObject;
    if (j < k)
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(j);
      if ((localObject instanceof MsgCardView)) {
        break label54;
      }
    }
    for (;;)
    {
      j += 1;
      break label24;
      break;
      label54:
      localObject = (MsgCardView)localObject;
      if ((i == 0) && ((((MsgCardView)localObject).a()) || (this.c)))
      {
        ((MsgCardView)localObject).a();
        i = 1;
      }
      else
      {
        ((MsgCardView)localObject).b();
      }
    }
  }
  
  private void c(boolean paramBoolean) {}
  
  private void d()
  {
    if (this.jdField_a_of_type_Bjhn != null)
    {
      this.jdField_a_of_type_Bjhn.c();
      this.jdField_a_of_type_Bjhn = null;
      if (this.jdField_a_of_type_Bjis != null) {
        this.jdField_a_of_type_Bjis.a(null, this.jdField_b_of_type_Boolean, this.c);
      }
    }
    if (this.jdField_a_of_type_ComTencentWidgetListView == null) {}
    int j;
    do
    {
      return;
      j = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
    } while (j <= 0);
    int i = 0;
    label66:
    View localView;
    if (i < j)
    {
      localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i);
      if ((localView instanceof MsgCardView)) {
        break label94;
      }
    }
    for (;;)
    {
      i += 1;
      break label66;
      break;
      label94:
      ((MsgCardView)localView).c();
    }
  }
  
  private void d(boolean paramBoolean) {}
  
  private void e()
  {
    if ((this.jdField_a_of_type_CooperationQzoneProviderLocalPhotoGroupData == null) || (this.jdField_a_of_type_CooperationQzoneProviderLocalPhotoGroupData.pathList == null) || (this.jdField_a_of_type_CooperationQzoneProviderLocalPhotoGroupData.pathList.isEmpty()))
    {
      boolean bool = a();
      QLog.e("QZoneMsgManager.QZoneMsgFragment", 2, "setLocalPhotoGroupData: removeLastEmptyMQMsg:" + bool + ", mLocalPhotoGroupData == null || mLocalPhotoGroupData.pathList == null || mLocalPhotoGroupData.pathList.isEmpty()");
    }
    MQMsg localMQMsg;
    do
    {
      do
      {
        return;
        localMQMsg = a();
        if (localMQMsg != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "setLocalPhotoGroupData: getLastMQMsg == null");
      return;
      if (QLog.isColorLevel())
      {
        QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "setLocalPhotoGroupData: getLastMQMsg{\nmsgType='" + localMQMsg.msgType + '\'' + '\n' + ", title=" + localMQMsg.title + '\'' + '\n' + ", eventTitle='" + localMQMsg.eventTitle + '\'' + '\n' + ", uniKey='" + localMQMsg.uniKey + '\'' + '\n' + '}');
        if ((localMQMsg.msgBody != null) && (localMQMsg.msgBody.photolist != null)) {
          localObject1 = localMQMsg.msgBody.photolist.iterator();
        }
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (MQPhotoCell)((Iterator)localObject1).next();
          QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "updateMQMsg: cell.coverUrl=" + ((MQPhotoCell)localObject2).coverUrl);
          continue;
          QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "updateMQMsg: mqMsg.msgBody.photolist==null");
        }
      }
    } while (((localMQMsg.msgBody.photolist != null) && (!localMQMsg.msgBody.photolist.isEmpty()) && (!bdnn.a(((MQPhotoCell)localMQMsg.msgBody.photolist.get(0)).coverUrl))) || (localMQMsg.msgType != 9));
    localMQMsg.uniKey = this.jdField_a_of_type_CooperationQzoneProviderLocalPhotoGroupData.unikey;
    localMQMsg.eventTitle = this.jdField_a_of_type_CooperationQzoneProviderLocalPhotoGroupData.title;
    localMQMsg.capTime = this.jdField_a_of_type_CooperationQzoneProviderLocalPhotoGroupData.capTime;
    Object localObject1 = new ArrayList();
    Object localObject2 = this.jdField_a_of_type_CooperationQzoneProviderLocalPhotoGroupData.pathList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      MQPhotoCell localMQPhotoCell = new MQPhotoCell();
      localMQPhotoCell.coverUrl = str;
      ((ArrayList)localObject1).add(localMQPhotoCell);
    }
    localMQMsg.msgBody.photolist = ((ArrayList)localObject1);
    this.jdField_a_of_type_AndroidOsHandler.post(new QZoneMsgFragment.8(this, localMQMsg));
    QLog.d("QZoneMsgManager.QZoneMsgFragment", 2, "setLocalPhotoGroupData: update last empty MQMsg.");
  }
  
  private void e(boolean paramBoolean)
  {
    c(paramBoolean);
    this.jdField_b_of_type_Int = 0;
    if (this.jdField_a_of_type_Bjis.getCount() > 0)
    {
      MQMsg localMQMsg = (MQMsg)this.jdField_a_of_type_Bjis.getItem(0);
      if (localMQMsg == null) {
        break label115;
      }
      b(localMQMsg.promot);
      if (QLog.isColorLevel()) {
        QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "updatePromptText ，mqMsg.promot=" + localMQMsg.promot);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "refreshFinish ，requestState=" + this.jdField_b_of_type_Int);
      }
      return;
      label115:
      if (QLog.isColorLevel()) {
        QLog.e("QZoneMsgManager.QZoneMsgFragment", 2, "updatePromptText mqMsg ==null");
      }
    }
  }
  
  public bjhn a()
  {
    return this.jdField_a_of_type_Bjhn;
  }
  
  public void a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramInt >= this.jdField_a_of_type_Bjis.getCount() - 1) && (this.jdField_a_of_type_Bjis.getCount() != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "onGetView loadMore");
      }
      a(false);
    }
  }
  
  public void a(MQMsg paramMQMsg)
  {
    Object localObject;
    if ((paramMQMsg != null) && (!TextUtils.isEmpty(paramMQMsg.jumpUrlToDetail)))
    {
      localObject = bdib.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), paramMQMsg.jumpUrlToDetail);
      if (localObject != null)
      {
        ((bdhk)localObject).c();
        return;
      }
      localObject = new Intent(getActivity(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramMQMsg.jumpUrlToDetail);
      bjdt.c((Intent)localObject);
      startActivity((Intent)localObject);
      return;
    }
    QLog.i("QZoneMsgManager.QZoneMsgFragment", 1, "msg.jumpUrlToDetail is null");
    if ((paramMQMsg != null) && (paramMQMsg.msgType == 9) && (!bdnn.a(paramMQMsg.uniKey)))
    {
      localObject = "mqqzone://arouse/photogrouprecommenddetail?usecache=true&checkgroup=false&unikey=" + paramMQMsg.uniKey;
      a((String)localObject);
      LpReportInfo_dc02880.report(2, 2, (String)localObject, "29", false, true);
      LpReportInfo_pf00064.allReport(133, 14, String.valueOf(paramMQMsg.msgType));
      QLog.i("QZoneMsgManager.QZoneMsgFragment", 1, "jumpToPhotoGroupRecommendDetail: uniKey=" + paramMQMsg.uniKey);
      return;
    }
    QLog.e("QZoneMsgManager.QZoneMsgFragment", 1, "msg == null | msg.msgType != ENUM_PUSH_MSG_TYPE._ENUM_TRAVEL_ALBUM | StringUtil.isEmpty(msg.uniKey)");
  }
  
  public void a(LocalPhotoGroupData paramLocalPhotoGroupData)
  {
    this.jdField_a_of_type_CooperationQzoneProviderLocalPhotoGroupData = paramLocalPhotoGroupData;
    e();
  }
  
  public void a(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setData(Uri.parse(paramString));
    localIntent.setPackage("com.tencent.mobileqq");
    getActivity().getApplicationContext().startActivity(localIntent);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      a();
      return true;
      if (QLog.isColorLevel()) {
        QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "EVENT_LOAD_MORE_MANUAL loadMore");
      }
      a(true);
      continue;
      this.jdField_a_of_type_Bjis.notifyDataSetChanged();
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    ThreadManagerV2.excute(new QZoneMsgFragment.5(this, (bjiy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(293)), 32, null, true);
    b();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1001);
    QZoneLoginReportHelper.reportLoginFromQZoneMsgBox();
    paramBundle = new LpReportInfo_dc02880(7, 1);
    LpReportManager.getInstance().reportToDC02880(paramBundle, false, true);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (QLog.isColorLevel()) {
      QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "fragment onAttach  ");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((BaseActivity)paramActivity).app;
    this.jdField_a_of_type_Bjix = new bjix(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Bjix);
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.qzone.sync_comment_like");
    getActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.c = bjho.d(paramActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (bjho.c()) {
      if (QzonePluginProxyActivity.a() == null)
      {
        QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new QZoneMsgFragment.1(this, paramActivity));
        this.jdField_b_of_type_Boolean = false;
      }
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        localObject = bjho.a();
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != localObject) {
          bjho.a(paramActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      }
      return;
      this.jdField_b_of_type_Boolean = this.c;
      continue;
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_Boolean = ThemeUtil.isNowThemeIsNightForQzone();
    if (this.jdField_a_of_type_Boolean) {
      paramViewGroup.setBackgroundColor(-16777216);
    }
    for (;;)
    {
      return paramLayoutInflater.inflate(2131562198, paramViewGroup, false);
      paramViewGroup.setBackgroundColor(-1380874);
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (QLog.isColorLevel()) {
      QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "fragment onDetach  ");
    }
    d();
    if (this.jdField_a_of_type_Bjix != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Bjix);
    }
    getActivity().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_Bjhn != null) {
      this.jdField_a_of_type_Bjhn.a();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_Bjhn != null) {
      this.jdField_a_of_type_Bjhn.b();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramView.findViewById(2131370803));
    paramBundle = paramView.findViewById(2131374609);
    AnyScaleTypeImageView localAnyScaleTypeImageView = (AnyScaleTypeImageView)paramBundle.findViewById(2131365741);
    localAnyScaleTypeImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    localAnyScaleTypeImageView.setImageURL(QzoneConfig.getInstance().getConfig("QZoneSetting", "content_box_empty_bg_url", "https://qzonestyle.gtimg.cn/aoi/sola/20190613205313_O1p1qwgOqi.png"));
    ((TextView)paramBundle.findViewById(2131365752)).setText(QzoneConfig.getInstance().getConfig("QZoneTextSetting", "ContentBoxEmptyText", "还没有收到过其它消息"));
    this.jdField_a_of_type_ComTencentWidgetListView.setEmptyView(paramBundle);
    paramBundle = getActivity();
    if ((this.jdField_b_of_type_Boolean) && (paramBundle != null))
    {
      this.jdField_a_of_type_Bjhn = bjho.a(paramBundle);
      if (this.jdField_a_of_type_Bjhn != null) {
        this.jdField_a_of_type_Bjhn.a(this.jdField_a_of_type_AndroidOsHandler);
      }
      this.jdField_a_of_type_Bjis = new bjis(getActivity());
      this.jdField_a_of_type_Bjis.a(this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Bjis.a(this.jdField_a_of_type_Bjhn, this.jdField_b_of_type_Boolean, this.c);
      this.jdField_a_of_type_Bjis.a(this);
      this.jdField_a_of_type_Bjis.a(this.jdField_a_of_type_Bjje);
      this.jdField_a_of_type_ComTencentWidgetListView.setOnScrollListener(this.jdField_a_of_type_Bhtv);
      this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Bjis);
      this.jdField_a_of_type_CooperationQzoneContentboxFootNavigationLayout = ((FootNavigationLayout)paramView.findViewById(2131370797));
      paramBundle = this.jdField_a_of_type_CooperationQzoneContentboxFootNavigationLayout;
      if (!this.c) {
        break label317;
      }
    }
    label317:
    for (int i = 0;; i = 8)
    {
      paramBundle.setArrowVisible(i);
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_CooperationQzoneContentboxFootNavigationLayout.setNightMode(true);
      }
      a(null);
      a(paramView);
      return;
      if (this.jdField_a_of_type_Bjhn == null) {
        break;
      }
      this.jdField_a_of_type_Bjhn.c();
      this.jdField_a_of_type_Bjhn = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgFragment
 * JD-Core Version:    0.7.0.1
 */