package com.tencent.richframework.common.fragment;

import android.os.Bundle;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.richframework.common.part.RFWChangeMsfServerPart;
import java.util.ArrayList;
import java.util.List;

public class RFWChangeMsfServerFragment
  extends BasePartFragment
{
  public String b()
  {
    return "QCircleChangeMsfServerFragment";
  }
  
  protected int c()
  {
    return 2131629199;
  }
  
  protected List<Part> d()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new RFWChangeMsfServerPart());
    return localArrayList;
  }
  
  protected int j()
  {
    return 0;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    getActivity().getWindow().setSoftInputMode(32);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.common.fragment.RFWChangeMsfServerFragment
 * JD-Core Version:    0.7.0.1
 */