package com.tencent.mobileqq.winkpublish.fragment;

import android.content.Intent;
import android.content.res.Resources;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.winkpublish.part.QCircleVideoPreviewPart;
import com.tencent.mobileqq.winkpublish.part.QCircleViewerPart;
import java.util.ArrayList;
import java.util.List;

public class QCircleUploadPreviewerFragment
  extends BasePartFragment
{
  private List<Part> a;
  private QCircleViewerPart b;
  private QCircleVideoPreviewPart c;
  
  private boolean a(Intent paramIntent)
  {
    return paramIntent.getBooleanExtra("key_photo_previewer_is_video", false);
  }
  
  public String b()
  {
    return "[QcirclePublish]QCircleUploadPreviewerFragment";
  }
  
  public boolean bh_()
  {
    return false;
  }
  
  protected int c()
  {
    return 2131627218;
  }
  
  protected List<Part> d()
  {
    if (this.a == null)
    {
      this.a = new ArrayList();
      if (!a(getActivity().getIntent()))
      {
        this.b = new QCircleViewerPart();
        this.b.a(getActivity().getIntent());
        this.a.add(this.b);
      }
      else
      {
        this.c = new QCircleVideoPreviewPart();
        this.c.a(getActivity().getIntent());
        this.a.add(this.c);
      }
    }
    return this.a;
  }
  
  protected int j()
  {
    return getResources().getColor(2131168376);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.fragment.QCircleUploadPreviewerFragment
 * JD-Core Version:    0.7.0.1
 */