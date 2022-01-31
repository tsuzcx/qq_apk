import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.StateSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class rec
  extends BaseAdapter
  implements View.OnClickListener
{
  public final int a;
  private Context jdField_a_of_type_AndroidContentContext;
  private final String jdField_a_of_type_JavaLangString = "ReadInJoyNavigationAdapter";
  private List<ChannelCoverInfo> jdField_a_of_type_JavaUtilList;
  private ree jdField_a_of_type_Ree;
  public int b = -13879999;
  public int c = -723466;
  
  public rec(Context paramContext)
  {
    this.jdField_a_of_type_Int = -9387998;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private List<ChannelCoverInfo> a(List<ChannelCoverInfo> paramList)
  {
    Object localObject = paramList;
    if (paramList != null)
    {
      localObject = paramList;
      if (paramList.size() > 28) {
        localObject = paramList.subList(0, 28);
      }
    }
    return localObject;
  }
  
  private void a(View paramView, int paramInt)
  {
    GradientDrawable localGradientDrawable1 = new GradientDrawable();
    localGradientDrawable1.setShape(0);
    localGradientDrawable1.setCornerRadius(bbll.a(17.0F));
    localGradientDrawable1.setColor(-723466);
    localGradientDrawable1.setStroke(1, paramInt);
    GradientDrawable localGradientDrawable2 = new GradientDrawable();
    localGradientDrawable2.setShape(0);
    localGradientDrawable2.setCornerRadius(bbll.a(17.0F));
    localGradientDrawable2.setColor(-2697514);
    localGradientDrawable2.setStroke(1, paramInt);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842919 }, localGradientDrawable2);
    localStateListDrawable.addState(StateSet.WILD_CARD, localGradientDrawable1);
    paramView.setBackgroundDrawable(localStateListDrawable);
  }
  
  public void a(List<ChannelCoverInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(a(paramList));
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNavigationAdapter", 2, new Object[] { "mChannels size: ", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
    }
    notifyDataSetChanged();
  }
  
  public void a(ree paramree)
  {
    this.jdField_a_of_type_Ree = paramree;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      localObject = new ref(this, null);
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559976, paramViewGroup, false);
      ((ref)localObject).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131364656);
      ((ref)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376835));
      paramView.setTag(localObject);
      paramViewGroup = (ViewGroup)localObject;
      localObject = (ChannelCoverInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (localObject != null)
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((ChannelCoverInfo)localObject).mChannelCoverName);
        int i = 5;
        paramInt = 12;
        if (bbdh.m() < 1080L)
        {
          i = 4;
          paramInt = 11;
        }
        if (paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.length() < i) {
          break label281;
        }
      }
    }
    for (;;)
    {
      float f = ajwc.a() / 16.0F;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextSize(paramInt / f);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(((ChannelCoverInfo)localObject).mFontColor);
      a(paramViewGroup.jdField_a_of_type_AndroidViewView, this.c);
      if (!TextUtils.isEmpty(((ChannelCoverInfo)localObject).mIconUrl)) {}
      for (;;)
      {
        if (!((ChannelCoverInfo)localObject).isReport)
        {
          ((ChannelCoverInfo)localObject).isReport = true;
          oep.a("0X8007F01", (ChannelCoverInfo)localObject, oep.b);
        }
        paramViewGroup.jdField_a_of_type_AndroidViewView.setTag(localObject);
        paramViewGroup.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
        return paramView;
        paramViewGroup = (ref)paramView.getTag();
        break;
        paramViewGroup.jdField_a_of_type_AndroidViewView.setPadding(bbll.a(8.0F), 0, bbll.a(8.0F), 0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
      }
      label281:
      paramInt = 14;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNavigationAdapter", 2, "click container");
    }
    ChannelCoverInfo localChannelCoverInfo = (ChannelCoverInfo)paramView.getTag();
    Object localObject;
    if (localChannelCoverInfo != null)
    {
      if (!TextUtils.isEmpty(localChannelCoverInfo.mChannelJumpUrl)) {
        break label252;
      }
      localObject = new HashMap();
      ((HashMap)localObject).put("param_key_ariticle_id", Long.valueOf(localChannelCoverInfo.mArticleId));
      ((HashMap)localObject).put("param_key_channel_cover_style", Integer.valueOf(localChannelCoverInfo.mChannelCoverStyle));
      nuq.a(this.jdField_a_of_type_AndroidContentContext, localChannelCoverInfo.mChannelCoverId, localChannelCoverInfo.mChannelCoverName, localChannelCoverInfo.mChannelType, 4, (Map)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNavigationAdapter", 2, "launchChannelActivity info.mArticleId:" + localChannelCoverInfo.mArticleId + " info.mChannelCoverStyle: " + localChannelCoverInfo.mChannelCoverStyle + " info.mChannelCoverId:" + localChannelCoverInfo.mChannelCoverId + " info.mChannelCoverName:" + localChannelCoverInfo.mChannelCoverName + " info.mChannelType: " + localChannelCoverInfo.mChannelType);
      }
    }
    label351:
    for (;;)
    {
      oep.a("0X8007F02", localChannelCoverInfo, oep.b);
      if ((this.jdField_a_of_type_Ree == null) || (!(paramView.getTag() instanceof ChannelCoverInfo))) {
        break;
      }
      this.jdField_a_of_type_Ree.a((ChannelCoverInfo)paramView.getTag());
      return;
      label252:
      if (rvx.b(localChannelCoverInfo.mChannelJumpUrl)) {
        rvx.a(this.jdField_a_of_type_AndroidContentContext, "", localChannelCoverInfo.mChannelJumpUrl, null);
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label351;
        }
        QLog.d("ReadInJoyNavigationAdapter", 2, "info.mChannelJumpUrl:" + localChannelCoverInfo.mChannelJumpUrl);
        break;
        localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", localChannelCoverInfo.mChannelJumpUrl);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rec
 * JD-Core Version:    0.7.0.1
 */