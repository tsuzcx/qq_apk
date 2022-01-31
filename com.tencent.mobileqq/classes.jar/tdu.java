import NS_KING_SOCIALIZE_META.stMetaComment;
import NS_KING_SOCIALIZE_META.stMetaPerson;
import NS_KING_SOCIALIZE_META.stMetaReply;
import android.content.Context;
import android.view.View;
import android.widget.ListView;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;

class tdu
  implements yde
{
  tdu(tdn paramtdn) {}
  
  public void a(View paramView, int paramInt1, int paramInt2, Object paramObject)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            return;
                            paramView = (String)paramObject;
                            paramView = "weishi://profile?person_id=" + paramView;
                            paramObject = tdn.a(this.a, paramView, 14);
                            if (xoo.a(tdn.a(this.a)))
                            {
                              tlq.a(tdn.a(this.a), "biz_src_jc_gzh_weishi", paramView, paramObject.mScene, paramObject.mLinkStrategyType, paramObject.mEventId);
                              WSPublicAccReport.getInstance().reportCommentTagClick(this.a.a(), WSPublicAccReport.getTagPositionId(this.a.a()) + tdn.c(this.a), 1000003, tdn.a(this.a));
                              return;
                            }
                            tfa.a(tdn.a(this.a), paramObject);
                            WSPublicAccReport.getInstance().reportCommentTagClick(this.a.a(), WSPublicAccReport.getTagPositionId(this.a.a()) + tdn.c(this.a), 1000002, tdn.a(this.a));
                            return;
                            WSPublicAccReport.getInstance().reportCommentPageClick(this.a.a(), WSPublicAccReport.getPagePositionId(this.a.a()) + tdn.c(this.a), 1000001, 6, tdn.a(this.a));
                            return;
                            paramView = ((stMetaPerson)paramObject).id;
                            paramView = "weishi://profile?person_id=" + paramView;
                            paramObject = tdn.a(this.a, paramView, 13);
                            if (xoo.a(tdn.a(this.a)))
                            {
                              tlq.a(tdn.a(this.a), "biz_src_jc_gzh_weishi", paramView, paramObject.mScene, paramObject.mLinkStrategyType, paramObject.mEventId);
                              WSPublicAccReport.getInstance().reportCommentPageClick(this.a.a(), WSPublicAccReport.getPagePositionId(this.a.a()) + tdn.c(this.a), 1000003, 2, tdn.a(this.a));
                              return;
                            }
                            tfa.a(tdn.a(this.a), paramObject, true);
                            WSPublicAccReport.getInstance().reportCommentPageClick(this.a.a(), WSPublicAccReport.getPagePositionId(this.a.a()) + tdn.c(this.a), 1000002, 2, tdn.a(this.a));
                            return;
                          } while (!(paramObject instanceof stMetaComment));
                          paramView = (stMetaComment)paramObject;
                          tdn.a(this.a, paramView, null, true, 0);
                          WSPublicAccReport.getInstance().reportCommentPageClick(this.a.a(), WSPublicAccReport.getPagePositionId(this.a.a()) + tdn.c(this.a), 1000001, 1, tdn.a(this.a));
                          return;
                        } while (!(paramObject instanceof Object[]));
                        paramObject = (Object[])paramObject;
                      } while ((paramObject.length <= 1) || (paramObject[0] == null) || (paramObject[1] == null) || (!(paramObject[0] instanceof stMetaComment)) || (!(paramObject[1] instanceof stMetaReply)));
                      paramView = (stMetaComment)paramObject[0];
                      paramObject = (stMetaReply)paramObject[1];
                      tdn.a(this.a, paramView, paramObject, true, 0);
                      WSPublicAccReport.getInstance().reportCommentReply(this.a.a(), tdn.c(this.a), 1002003, tdn.a(this.a));
                      return;
                    } while (!(paramObject instanceof stMetaComment));
                    paramView = (stMetaComment)paramObject;
                    tdn.a(this.a).a(paramView);
                    WSPublicAccReport.getInstance().reportCommentPageClick(this.a.a(), WSPublicAccReport.getPagePositionId(this.a.a()) + tdn.c(this.a), 1000001, 5, tdn.a(this.a));
                    return;
                  } while (!(paramObject instanceof Object[]));
                  paramView = (Object[])paramObject;
                } while ((paramView.length <= 1) || (paramView[0] == null));
                paramObject = (stMetaComment)paramView[0];
                paramInt1 = tdn.a(this.a).a(paramObject);
              } while ((paramInt1 < 0) || (paramView[1] == null));
              int i = ((Integer)paramView[1]).intValue();
              this.a.jdField_a_of_type_AndroidWidgetListView.setSelectionFromTop(paramInt2, i * (paramInt1 * -1));
              return;
            } while (!(paramObject instanceof stMetaComment));
            paramView = (stMetaComment)paramObject;
            tdn.b(this.a, this.a.a().a(tdn.a(this.a), paramView));
            this.a.jdField_a_of_type_Boolean = true;
            tlo.d("comment", "3 mCommentListChanged:" + this.a.jdField_a_of_type_Boolean + ",clickPosition:" + paramInt2);
            WSPublicAccReport.getInstance().reportCommentPageClick(this.a.a(), WSPublicAccReport.getPagePositionId(this.a.a()) + tdn.c(this.a), 1000001, 3, tdn.a(this.a));
          } while (!(tdn.a(this.a) instanceof WSFollowFragment));
          paramInt1 = paramInt2 - 1;
          paramView = ((WSFollowFragment)tdn.a(this.a)).a().a().findViewHolderForAdapterPosition(tdn.a(this.a));
        } while (!(paramView instanceof tfk));
        paramView = (tfk)paramView;
        tlo.c("comment", "***getPosition():" + tdn.a(this.a) + ",realPosition:" + paramInt1);
        paramView.a(paramInt1);
        return;
      } while (!(paramObject instanceof Object[]));
      paramView = (Object[])paramObject;
    } while ((paramView.length <= 1) || (paramView[0] == null) || (paramView[1] == null));
    paramObject = (stMetaComment)paramView[0];
    this.a.a().a(tdn.a(this.a), paramObject, (stMetaReply)paramView[1]);
    this.a.jdField_a_of_type_Boolean = true;
    tlo.d("comment", "4 mCommentListChanged:" + this.a.jdField_a_of_type_Boolean);
    WSPublicAccReport.getInstance().reportCommentPageClick(this.a.a(), WSPublicAccReport.getPagePositionId(this.a.a()) + tdn.c(this.a), 1000001, 3, tdn.a(this.a));
  }
  
  public void b(View paramView, int paramInt1, int paramInt2, Object paramObject)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramObject instanceof stMetaComment));
        paramView = (stMetaComment)paramObject;
        tdn.a(this.a, new yav(tdn.a(this.a), false, true));
        tdn.a(this.a).a(tdn.a(this.a).getString(2131691356), 0, new tdv(this, paramView));
        if (tdn.a(this.a, paramView.poster)) {
          tdn.a(this.a).a(tdn.a(this.a).getString(2131691555), 1, new tdw(this, paramView));
        }
        for (;;)
        {
          tdn.a(this.a).a(tdn.a(this.a).getString(2131690648));
          tdn.a(this.a).show();
          return;
          tdn.a(this.a).a(tdn.a(this.a).getString(2131719217), 6, new tdx(this));
        }
      } while (!(paramObject instanceof Object[]));
      paramObject = (Object[])paramObject;
    } while ((paramObject.length <= 1) || (paramObject[0] == null) || (paramObject[1] == null) || (!(paramObject[0] instanceof stMetaComment)) || (!(paramObject[1] instanceof stMetaReply)));
    paramView = (stMetaComment)paramObject[0];
    paramObject = (stMetaReply)paramObject[1];
    tdn.a(this.a, new yav(tdn.a(this.a), false, true));
    tdn.a(this.a).a(tdn.a(this.a).getString(2131691356), 0, new tdy(this, paramObject));
    if (tdn.a(this.a, paramObject.poster)) {
      tdn.a(this.a).a(tdn.a(this.a).getString(2131691555), 1, new tdz(this, paramView, paramObject));
    }
    for (;;)
    {
      tdn.a(this.a).a(tdn.a(this.a).getString(2131690648));
      tdn.a(this.a).show();
      return;
      tdn.a(this.a).a(tdn.a(this.a).getString(2131719217), 6, new tea(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tdu
 * JD-Core Version:    0.7.0.1
 */