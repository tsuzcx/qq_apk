import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.channelCover.ChannelCoverView.1;
import com.tencent.biz.pubaccount.readinjoy.channelCover.ChannelCoverView.2;
import com.tencent.biz.pubaccount.readinjoy.channelCover.ChannelCoverView.3;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;

public class oxo
  implements AdapterView.OnItemClickListener
{
  public static int a;
  public static int b = 1;
  private Context jdField_a_of_type_AndroidContentContext;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private ArrayList<ChannelCoverInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private oxm jdField_a_of_type_Oxm;
  protected pvq a;
  private int c;
  
  static
  {
    jdField_a_of_type_Int = 2;
  }
  
  public oxo(Context paramContext, int paramInt, ListView paramListView)
  {
    this.jdField_a_of_type_Pvq = new oxq(this, null);
    this.c = paramInt;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)pvj.a().a(paramInt));
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverView", 2, "ChannelCoverView createSimpleView");
    }
    a(paramContext);
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      this.jdField_a_of_type_ComTencentWidgetListView.addHeaderView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    }
    pvm.a().a(this.jdField_a_of_type_Pvq);
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      pvj.a().c(paramInt);
    }
    pvj.a().a(paramInt);
  }
  
  public static void a(String paramString, ChannelCoverInfo paramChannelCoverInfo, int paramInt)
  {
    a(paramString, paramChannelCoverInfo, paramInt, -1, -1);
  }
  
  public static void a(String paramString, ChannelCoverInfo paramChannelCoverInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    ThreadManager.post(new ChannelCoverView.3(paramChannelCoverInfo, paramInt1, paramInt2, paramInt3, paramString), 5, null, true);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, ChannelCoverInfo paramChannelCoverInfo, int paramInt)
  {
    ThreadManager.executeOnSubThread(new ChannelCoverView.2(paramChannelCoverInfo, paramInt, paramString1, paramString2, paramString3, paramString4));
  }
  
  public LinearLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  public void a()
  {
    pvm.a().b(this.jdField_a_of_type_Pvq);
    this.jdField_a_of_type_JavaUtilArrayList = null;
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverView", 2, "onDestroy()");
    }
  }
  
  void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(paramContext).inflate(2131558850, null, false));
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131365119);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131381482));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(AIOUtils.dp2px(6.0F, paramContext.getResources()));
    this.jdField_a_of_type_Oxm = new oxm(paramContext, this.jdField_a_of_type_JavaUtilArrayList, this.c);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Oxm);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
    if (this.c == 56)
    {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnTouchListener(new oxp(this, paramContext));
      localLinearLayout.setPadding(0, (int)bhdz.a(paramContext, 2.0F), 0, (int)bhdz.a(paramContext, 2.0F));
    }
    if (this.c == 41523) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(0, AIOUtils.dp2px(10.0F, paramContext.getResources()), 0, 0);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > paramInt)
    {
      paramAdapterView = (ChannelCoverInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if (!TextUtils.isEmpty(paramAdapterView.mChannelJumpUrl)) {
        break label249;
      }
      paramView = new HashMap();
      paramView.put("param_key_ariticle_id", Long.valueOf(paramAdapterView.mArticleId));
      paramView.put("param_key_channel_cover_style", Integer.valueOf(paramAdapterView.mChannelCoverStyle));
      if (this.c != 56) {
        break label225;
      }
      osg.b(this.jdField_a_of_type_AndroidContentContext, paramAdapterView.mChannelCoverId, paramAdapterView.mChannelCoverName, paramAdapterView.mChannelType, 4, paramView);
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverView", 2, "launchChannelActivity info.mArticleId:" + paramAdapterView.mArticleId + " info.mChannelCoverStyle: " + paramAdapterView.mChannelCoverStyle + " info.mChannelCoverId:" + paramAdapterView.mChannelCoverId + " info.mChannelCoverName:" + paramAdapterView.mChannelCoverName + " info.mChannelType: " + paramAdapterView.mChannelType);
      }
      if (this.c == 56) {
        ThreadManager.executeOnSubThread(new ChannelCoverView.1(this, paramAdapterView));
      }
    }
    for (;;)
    {
      if (this.c == 0) {
        a("0X8007F02", paramAdapterView, jdField_a_of_type_Int);
      }
      return;
      label225:
      osg.a(this.jdField_a_of_type_AndroidContentContext, paramAdapterView.mChannelCoverId, paramAdapterView.mChannelCoverName, paramAdapterView.mChannelType, 4, paramView);
      break;
      label249:
      paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramView.putExtra("url", paramAdapterView.mChannelJumpUrl);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverView", 2, "info.mChannelJumpUrl:" + paramAdapterView.mChannelJumpUrl);
      }
      paramAdapterView.mPreUpdateTime = paramAdapterView.mUpdateTime;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oxo
 * JD-Core Version:    0.7.0.1
 */