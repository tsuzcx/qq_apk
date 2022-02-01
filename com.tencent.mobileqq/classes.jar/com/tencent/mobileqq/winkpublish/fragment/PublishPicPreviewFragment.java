package com.tencent.mobileqq.winkpublish.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.winkpublish.base.PublishBaseFragment;
import com.tencent.mobileqq.winkpublish.part.PublishPicPreviewPart;
import com.tencent.mobileqq.winkpublish.util.QCircleThemeUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import java.util.ArrayList;
import java.util.List;

public class PublishPicPreviewFragment
  extends PublishBaseFragment
{
  private List<Part> b;
  
  public String b()
  {
    return "PublishPicPreviewFragment";
  }
  
  protected int c()
  {
    return 2131627213;
  }
  
  protected List<Part> d()
  {
    this.b = new ArrayList();
    PublishPicPreviewPart localPublishPicPreviewPart = new PublishPicPreviewPart();
    this.b.add(localPublishPicPreviewPart);
    return this.b;
  }
  
  public String e()
  {
    return null;
  }
  
  protected int j()
  {
    return 0;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    QCircleThemeUtil.a(getActivity(), QCircleSkinHelper.getInstance().getColor(-16777216));
    ImmersiveUtils.setStatusTextColor(false, getActivity().getWindow());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.fragment.PublishPicPreviewFragment
 * JD-Core Version:    0.7.0.1
 */