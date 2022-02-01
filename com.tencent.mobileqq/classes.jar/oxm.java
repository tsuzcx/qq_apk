import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class oxm
  extends BaseAdapter
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private ArrayList<ChannelCoverInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public oxm(Context paramContext, ArrayList<ChannelCoverInfo> paramArrayList, int paramInt)
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
    int j = 0;
    Object localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources();
    Object localObject1;
    if (getItemViewType(paramInt) == 0)
    {
      localObject1 = paramView;
      if (paramView == null)
      {
        localObject1 = new View(this.jdField_a_of_type_AndroidContentContext);
        ((View)localObject1).setLayoutParams(new ViewGroup.LayoutParams(AIOUtils.dp2px(2.0F, (Resources)localObject2), AIOUtils.dp2px(30.0F, (Resources)localObject2)));
      }
      paramView = (View)localObject1;
      localObject2 = localObject1;
      localObject1 = paramView;
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return localObject2;
    }
    if (paramView == null)
    {
      localObject1 = new oxn(this);
      paramView = new ReadInJoyVideoTopicTextView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setId(2131376171);
      paramView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      ((oxn)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoTopicTextView = paramView;
      paramView.setTag(localObject1);
      label152:
      localObject2 = (ChannelCoverInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if (localObject2 != null)
      {
        if (((ChannelCoverInfo)localObject2).mColumnType != 1) {
          break label438;
        }
        ((oxn)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoTopicTextView.setTopicText(((ChannelCoverInfo)localObject2).mChannelCoverName);
        label192:
        if (this.jdField_a_of_type_Int != 56) {
          break label454;
        }
        ((oxn)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoTopicTextView.setTextColor(7566195);
        label211:
        if (TextUtils.isEmpty(((ChannelCoverInfo)localObject2).mIconUrl)) {
          break label470;
        }
        int i = ViewUtils.dip2px(21.0F);
        Object localObject3 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840479);
        localObject3 = URLDrawable.getDrawable(((ChannelCoverInfo)localObject2).mIconUrl, i, i, (Drawable)localObject3, (Drawable)localObject3);
        if ((localObject3 != null) && (((URLDrawable)localObject3).getStatus() == 2)) {
          ((URLDrawable)localObject3).restartDownload();
        }
        ((URLDrawable)localObject3).setBounds(0, 0, i, i);
        ((oxn)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoTopicTextView.setCompoundDrawables((Drawable)localObject3, null, null, null);
        label304:
        if (!((ChannelCoverInfo)localObject2).isReport)
        {
          ((ChannelCoverInfo)localObject2).isReport = true;
          if (this.jdField_a_of_type_Int != 56) {
            break label485;
          }
          i = j;
          if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
          {
            i = j;
            if (((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent() != null) {
              i = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getIntExtra("channel_from", -1);
            }
          }
          oxo.a("0X8007BE5", "1", "", "", (ChannelCoverInfo)localObject2, i);
        }
      }
    }
    for (;;)
    {
      oxo.a("0X8007F01", (ChannelCoverInfo)localObject2, oxo.b);
      ((oxn)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoTopicTextView.setOnClickListener(this);
      ((oxn)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo = ((ChannelCoverInfo)localObject2);
      localObject1 = paramView;
      localObject2 = paramView;
      break;
      localObject1 = (oxn)paramView.getTag();
      break label152;
      label438:
      ((oxn)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoTopicTextView.setSubChannelText(((ChannelCoverInfo)localObject2).mChannelCoverName);
      break label192;
      label454:
      ((oxn)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoTopicTextView.setTextColor(((ChannelCoverInfo)localObject2).mFontColor);
      break label211;
      label470:
      ((oxn)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoTopicTextView.setCompoundDrawables(null, null, null, null);
      break label304;
      label485:
      if (pqw.a(this.jdField_a_of_type_Int)) {
        pih.a(this.jdField_a_of_type_AndroidContentContext, "0X8009A70", this.jdField_a_of_type_Int, ((ChannelCoverInfo)localObject2).mChannelCoverId);
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
    ChannelCoverInfo localChannelCoverInfo;
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("READINJOYChannelCoverSimpleAdapter", 2, "click readinjoy_feeds_video_label_textview");
      }
      localChannelCoverInfo = ((oxn)paramView.getTag()).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo;
    } while (localChannelCoverInfo == null);
    Object localObject;
    if (TextUtils.isEmpty(localChannelCoverInfo.mChannelJumpUrl))
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("param_key_ariticle_id", Long.valueOf(localChannelCoverInfo.mArticleId));
      ((HashMap)localObject).put("param_key_channel_cover_style", Integer.valueOf(localChannelCoverInfo.mChannelCoverStyle));
      ((HashMap)localObject).put("param_key_channel_column_type", Integer.valueOf(localChannelCoverInfo.mColumnType));
      if (this.jdField_a_of_type_Int == 56)
      {
        osg.b(this.jdField_a_of_type_AndroidContentContext, localChannelCoverInfo.mChannelCoverId, localChannelCoverInfo.mChannelCoverName, localChannelCoverInfo.mChannelType, 4, (Map)localObject);
        label155:
        if (QLog.isColorLevel()) {
          QLog.d("READINJOYChannelCoverSimpleAdapter", 2, "launchChannelActivity info.mArticleId:" + localChannelCoverInfo.mArticleId + " info.mChannelCoverStyle: " + localChannelCoverInfo.mChannelCoverStyle + " info.mChannelCoverId:" + localChannelCoverInfo.mChannelCoverId + " info.mChannelCoverName:" + localChannelCoverInfo.mChannelCoverName + " info.mChannelType: " + localChannelCoverInfo.mChannelType);
        }
        if (this.jdField_a_of_type_Int == 56) {
          ThreadManager.executeOnSubThread(new ChannelCoverSimpleAdapter.1(this, localChannelCoverInfo));
        }
      }
    }
    label430:
    for (;;)
    {
      if (pqw.a(this.jdField_a_of_type_Int)) {
        pih.a(this.jdField_a_of_type_AndroidContentContext, "0X8009A71", this.jdField_a_of_type_Int, localChannelCoverInfo.mChannelCoverId);
      }
      oxo.a("0X8007F02", localChannelCoverInfo, oxo.b);
      break;
      osg.a(this.jdField_a_of_type_AndroidContentContext, localChannelCoverInfo.mChannelCoverId, localChannelCoverInfo.mChannelCoverName, localChannelCoverInfo.mChannelType, 4, (Map)localObject);
      break label155;
      if (tto.b(localChannelCoverInfo.mChannelJumpUrl)) {
        tto.a(this.jdField_a_of_type_AndroidContentContext, "", tto.b(localChannelCoverInfo.mChannelJumpUrl), null);
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label430;
        }
        QLog.d("READINJOYChannelCoverSimpleAdapter", 2, "info.mChannelJumpUrl:" + localChannelCoverInfo.mChannelJumpUrl);
        break;
        localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", localChannelCoverInfo.mChannelJumpUrl);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oxm
 * JD-Core Version:    0.7.0.1
 */