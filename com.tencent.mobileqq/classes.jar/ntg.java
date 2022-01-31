import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.channelCover.ChannelCoverSimpleAdapter.1;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyVideoTopicTextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ntg
  extends BaseAdapter
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private ArrayList<ChannelCoverInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public ntg(Context paramContext, ArrayList<ChannelCoverInfo> paramArrayList, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    if (paramArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      paramContext = new ChannelCoverInfo();
      this.jdField_a_of_type_JavaUtilArrayList.add(paramContext);
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
      paramContext = new ChannelCoverInfo();
      this.jdField_a_of_type_JavaUtilArrayList.add(paramContext);
    }
  }
  
  public ChannelCoverInfo a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return (ChannelCoverInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public void a(ArrayList<ChannelCoverInfo> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("READINJOYChannelCoverSimpleAdapter", 2, "setData size" + paramArrayList.size());
    }
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      ChannelCoverInfo localChannelCoverInfo = new ChannelCoverInfo();
      this.jdField_a_of_type_JavaUtilArrayList.add(localChannelCoverInfo);
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
      paramArrayList = new ChannelCoverInfo();
      this.jdField_a_of_type_JavaUtilArrayList.add(paramArrayList);
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("READINJOYChannelCoverSimpleAdapter", 2, "getCount()" + this.jdField_a_of_type_JavaUtilArrayList.size());
      }
      return this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt == 0) || ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt == this.jdField_a_of_type_JavaUtilArrayList.size() - 1))) {
      return 0;
    }
    return 1;
  }
  
  @TargetApi(16)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = 0;
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
    if (getItemViewType(paramInt) == 0)
    {
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramViewGroup = new View(this.jdField_a_of_type_AndroidContentContext);
        paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(aciy.a(2.0F, (Resources)localObject), aciy.a(30.0F, (Resources)localObject)));
      }
    }
    ChannelCoverInfo localChannelCoverInfo;
    do
    {
      return paramViewGroup;
      if (paramView != null) {
        break;
      }
      localObject = new nth(this);
      paramView = new ReadInJoyVideoTopicTextView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setId(2131309033);
      paramView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      ((nth)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoTopicTextView = paramView;
      paramView.setTag(localObject);
      localChannelCoverInfo = (ChannelCoverInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      paramViewGroup = paramView;
    } while (localChannelCoverInfo == null);
    if (localChannelCoverInfo.mColumnType == 1)
    {
      ((nth)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoTopicTextView.setTopicText(localChannelCoverInfo.mChannelCoverName);
      label165:
      if (this.jdField_a_of_type_Int != 56) {
        break label402;
      }
      ((nth)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoTopicTextView.setTextColor(7566195);
      label184:
      if (TextUtils.isEmpty(localChannelCoverInfo.mIconUrl)) {
        break label418;
      }
      paramInt = bajq.a(21.0F);
      paramViewGroup = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840063);
      paramViewGroup = URLDrawable.getDrawable(localChannelCoverInfo.mIconUrl, paramInt, paramInt, paramViewGroup, paramViewGroup);
      if ((paramViewGroup != null) && (paramViewGroup.getStatus() == 2)) {
        paramViewGroup.restartDownload();
      }
      paramViewGroup.setBounds(0, 0, paramInt, paramInt);
      ((nth)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoTopicTextView.setCompoundDrawables(paramViewGroup, null, null, null);
      label263:
      if (!localChannelCoverInfo.isReport)
      {
        localChannelCoverInfo.isReport = true;
        if (this.jdField_a_of_type_Int != 56) {
          break label433;
        }
        paramInt = i;
        if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
        {
          paramInt = i;
          if (((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent() != null) {
            paramInt = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getIntExtra("channel_from", -1);
          }
        }
        nti.a("0X8007BE5", "1", "", "", localChannelCoverInfo, paramInt);
      }
    }
    for (;;)
    {
      nti.a("0X8007F01", localChannelCoverInfo, nti.b);
      ((nth)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoTopicTextView.setOnClickListener(this);
      ((nth)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo = localChannelCoverInfo;
      return paramView;
      localObject = (nth)paramView.getTag();
      break;
      ((nth)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoTopicTextView.setSubChannelText(localChannelCoverInfo.mChannelCoverName);
      break label165;
      label402:
      ((nth)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoTopicTextView.setTextColor(localChannelCoverInfo.mFontColor);
      break label184;
      label418:
      ((nth)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoTopicTextView.setCompoundDrawables(null, null, null, null);
      break label263;
      label433:
      if (obz.a(this.jdField_a_of_type_Int)) {
        nzv.a(this.jdField_a_of_type_AndroidContentContext, "0X8009A70", this.jdField_a_of_type_Int, localChannelCoverInfo.mChannelCoverId);
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("READINJOYChannelCoverSimpleAdapter", 2, "click readinjoy_feeds_video_label_textview");
      }
      paramView = ((nth)paramView.getTag()).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo;
    } while (paramView == null);
    Object localObject;
    if (TextUtils.isEmpty(paramView.mChannelJumpUrl))
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("param_key_ariticle_id", Long.valueOf(paramView.mArticleId));
      ((HashMap)localObject).put("param_key_channel_cover_style", Integer.valueOf(paramView.mChannelCoverStyle));
      ((HashMap)localObject).put("param_key_channel_column_type", Integer.valueOf(paramView.mColumnType));
      if (this.jdField_a_of_type_Int == 56)
      {
        nji.b(this.jdField_a_of_type_AndroidContentContext, paramView.mChannelCoverId, paramView.mChannelCoverName, paramView.mChannelType, 4, (Map)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("READINJOYChannelCoverSimpleAdapter", 2, "launchChannelActivity info.mArticleId:" + paramView.mArticleId + " info.mChannelCoverStyle: " + paramView.mChannelCoverStyle + " info.mChannelCoverId:" + paramView.mChannelCoverId + " info.mChannelCoverName:" + paramView.mChannelCoverName + " info.mChannelType: " + paramView.mChannelType);
        }
        if (this.jdField_a_of_type_Int == 56) {
          ThreadManager.executeOnSubThread(new ChannelCoverSimpleAdapter.1(this, paramView));
        }
      }
    }
    label421:
    for (;;)
    {
      if (obz.a(this.jdField_a_of_type_Int)) {
        nzv.a(this.jdField_a_of_type_AndroidContentContext, "0X8009A71", this.jdField_a_of_type_Int, paramView.mChannelCoverId);
      }
      nti.a("0X8007F02", paramView, nti.b);
      return;
      nji.a(this.jdField_a_of_type_AndroidContentContext, paramView.mChannelCoverId, paramView.mChannelCoverName, paramView.mChannelType, 4, (Map)localObject);
      break;
      if (rjb.b(paramView.mChannelJumpUrl)) {
        rjb.a(this.jdField_a_of_type_AndroidContentContext, "", rjb.b(paramView.mChannelJumpUrl), null);
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label421;
        }
        QLog.d("READINJOYChannelCoverSimpleAdapter", 2, "info.mChannelJumpUrl:" + paramView.mChannelJumpUrl);
        break;
        localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramView.mChannelJumpUrl);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ntg
 * JD-Core Version:    0.7.0.1
 */