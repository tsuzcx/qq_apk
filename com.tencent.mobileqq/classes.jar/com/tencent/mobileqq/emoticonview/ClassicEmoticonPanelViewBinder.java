package com.tencent.mobileqq.emoticonview;

import acfj;
import android.content.Context;
import android.view.View;
import java.util.List;

public class ClassicEmoticonPanelViewBinder
  extends EmoticonPanelViewBinder
{
  private EmoticonCallback jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback;
  private EmoticonLinearLayout.EmoticonAdapter jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter;
  private List jdField_a_of_type_JavaUtilList;
  
  public ClassicEmoticonPanelViewBinder(Context paramContext, EmoticonCallback paramEmoticonCallback, int paramInt)
  {
    super(paramContext, 7, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = paramEmoticonCallback;
  }
  
  public int a()
  {
    return SystemAndEmojiEmoticonInfo.f + SystemAndEmojiEmoticonInfo.g;
  }
  
  protected int a(int paramInt)
  {
    return 2007;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = null;
  }
  
  protected void a(View paramView, int paramInt)
  {
    if (paramView == null) {}
    int i;
    do
    {
      do
      {
        return;
        i = a(paramInt);
      } while (paramInt >= a());
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = SystemAndEmojiEmoticonInfo.a();
      }
    } while (i != 2007);
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter = new acfj(this, 2007);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.a(true);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.c(false);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.b(false);
      EmoticonInfo localEmoticonInfo = new EmoticonInfo();
      localEmoticonInfo.a = "delete";
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.a(localEmoticonInfo);
    }
    paramView = (EmoticonLinearLayout)paramView;
    paramView.setCallBack(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback);
    paramView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.a(3, 7);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.a(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ClassicEmoticonPanelViewBinder
 * JD-Core Version:    0.7.0.1
 */