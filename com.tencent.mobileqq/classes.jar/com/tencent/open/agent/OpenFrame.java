package com.tencent.open.agent;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.tencent.common.app.InnerFrame;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.open.agent.datamodel.FriendDataManager;
import java.util.ArrayList;
import java.util.List;

public abstract class OpenFrame
  extends InnerFrame
{
  protected LayoutInflater a;
  protected InnerFrameManager a;
  protected BaseQQAppInterface a;
  protected FriendChooser a;
  protected FriendDataManager a;
  
  public OpenFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public List<Friend> a()
  {
    ArrayList localArrayList = new ArrayList(50);
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.b())
    {
      localArrayList.addAll(this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a(i));
      i += 1;
    }
    return localArrayList;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_a_of_type_ComTencentOpenAgentFriendChooser = ((FriendChooser)super.a());
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager = super.a();
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = super.a();
    this.jdField_a_of_type_AndroidViewLayoutInflater = this.jdField_a_of_type_ComTencentOpenAgentFriendChooser.getLayoutInflater();
    this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager = FriendDataManager.a();
  }
  
  public abstract void g();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.OpenFrame
 * JD-Core Version:    0.7.0.1
 */