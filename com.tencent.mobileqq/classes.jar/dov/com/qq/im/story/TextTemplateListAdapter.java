package dov.com.qq.im.story;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.qqstory.config.TextFilterConfig.TextTemplateConfig;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class TextTemplateListAdapter
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private List<TextFilterConfig.TextTemplateConfig> jdField_a_of_type_JavaUtilList;
  private int b;
  
  private void a(int paramInt, View paramView)
  {
    TextFilterConfig.TextTemplateConfig localTextTemplateConfig = a(paramInt);
    TextView localTextView = (TextView)paramView.findViewById(2131379015);
    ImageView localImageView = (ImageView)paramView.findViewById(2131379005);
    View localView = paramView.findViewById(2131379013);
    ProgressBar localProgressBar = (ProgressBar)paramView.findViewById(2131379010);
    localTextView.setText(localTextTemplateConfig.b);
    if (this.b == 0) {
      this.b = UIUtils.a(paramView.getContext(), 60.0F);
    }
    UIUtils.a(localImageView, localTextTemplateConfig.h, this.b, this.b, paramView.getContext().getResources().getDrawable(2130847108), null);
    if (paramInt == this.jdField_a_of_type_Int)
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label186;
      }
      localView.setVisibility(0);
      paramView.setContentDescription(HardCodeUtil.a(2131714757) + localTextTemplateConfig.b + "’");
    }
    for (;;)
    {
      if (localTextTemplateConfig.c) {
        break label233;
      }
      localProgressBar.setVisibility(0);
      localTextView.setVisibility(8);
      return;
      paramInt = 0;
      break;
      label186:
      localView.setVisibility(8);
      paramView.setContentDescription(HardCodeUtil.a(2131714758) + localTextTemplateConfig.b + HardCodeUtil.a(2131714756));
    }
    label233:
    localProgressBar.setVisibility(8);
    localTextView.setVisibility(0);
  }
  
  public TextFilterConfig.TextTemplateConfig a(int paramInt)
  {
    return (TextFilterConfig.TextTemplateConfig)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561018, paramViewGroup, false);
      paramView.setFocusable(true);
    }
    for (;;)
    {
      a(paramInt, paramView);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.qq.im.story.TextTemplateListAdapter
 * JD-Core Version:    0.7.0.1
 */