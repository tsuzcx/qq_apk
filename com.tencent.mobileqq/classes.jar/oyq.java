import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/comment/CommentProteusListenerUtil$Companion;", "", "()V", "TAG", "", "doReplyClick", "", "cmdStrId", "", "container", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/container/Container;", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/comment/ReadinjoyCommentListBaseAdapter;", "commentViewItem", "Lcom/tencent/biz/pubaccount/readinjoy/comment/data/CommentViewItem;", "viewBase", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "getOnClickListener", "Lcom/tencent/biz/pubaccount/readinjoy/comment/CommentProteusListenerUtil$CommentProteusOnClickListener;", "onClickListenerSparseArray", "Landroid/util/SparseArray;", "initChooseCommentTypeClickListener", "initCommentActivityClickListener", "initCommentBannerClickListener", "initCommentContentClickListener", "initCommentDotClickListener", "initCommentFlowGuideClickListener", "initCommentHideButtonClickListener", "initCommentMediaClickListener", "initCommentReplyClickListener", "initDefaultClickListener", "initDeleteCommentClickListener", "initExposeCommentClickListener", "initExposeSubCommentOneClickListener", "initExposeSubCommentTwoClickListener", "initHeadMedalClickListener", "initLikeClickListener", "initOnClickListener", "initSocialAvatarOnClickListener", "putOnClickListenerIntoSparseArray", "onClickListener", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class oyq
{
  private final oyp a()
  {
    return (oyp)new ozj();
  }
  
  private final oyp a(int paramInt)
  {
    if (paramInt != 1023) {
      return null;
    }
    return (oyp)new ozv();
  }
  
  private final void a(int paramInt, Container paramContainer, pcf parampcf, pdp parampdp, ViewBase paramViewBase)
  {
    if (parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
    {
      paramContainer = new paa(parampdp).a().a();
      olh.a(null, pbq.a(parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X8009010", "0X8009010", 0, 0, String.valueOf(parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, paramContainer, false);
    }
    if ((parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData))
    {
      paramContainer = parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      if (paramContainer == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData");
      }
      if (((CommentData)paramContainer).subCommentNum > 0)
      {
        if ((parampcf instanceof pau)) {
          ((pau)parampcf).a(parampdp, ozx.a(parampdp, -1), 1);
        }
        return;
      }
    }
    parampcf.a(parampdp);
  }
  
  private final void a(int paramInt, oyp paramoyp, SparseArray<oyp> paramSparseArray)
  {
    if (paramoyp != null) {
      paramSparseArray.put(paramInt, paramoyp);
    }
  }
  
  private final oyp b(int paramInt)
  {
    if (paramInt != 1002) {
      return null;
    }
    return (oyp)new ozu();
  }
  
  private final oyp c(int paramInt)
  {
    if (paramInt != 1062) {
      return null;
    }
    return (oyp)new oyt();
  }
  
  private final oyp d(int paramInt)
  {
    if (paramInt != 1055) {
      return null;
    }
    return (oyp)new ozh();
  }
  
  private final oyp e(int paramInt)
  {
    if (paramInt != 1059) {
      return null;
    }
    return (oyp)new ozl();
  }
  
  private final oyp f(int paramInt)
  {
    if (paramInt != 1056) {
      return null;
    }
    return (oyp)new oyy();
  }
  
  private final oyp g(int paramInt)
  {
    if (paramInt != 1060) {
      return null;
    }
    return (oyp)new ozn();
  }
  
  private final oyp h(int paramInt)
  {
    if (paramInt != 1061) {
      return null;
    }
    return (oyp)new oyx();
  }
  
  private final oyp i(int paramInt)
  {
    if (paramInt != 1064) {
      return null;
    }
    return (oyp)new ozs();
  }
  
  private final oyp j(int paramInt)
  {
    if (paramInt != 1072) {
      return null;
    }
    return (oyp)new oyv();
  }
  
  private final oyp k(int paramInt)
  {
    if (paramInt != 1073) {
      return null;
    }
    return (oyp)new oyr();
  }
  
  private final oyp l(int paramInt)
  {
    if (paramInt != 1093) {
      return null;
    }
    return (oyp)new ozb();
  }
  
  private final oyp m(int paramInt)
  {
    if (paramInt != 1094) {
      return null;
    }
    return (oyp)new ozf();
  }
  
  private final oyp n(int paramInt)
  {
    if (paramInt != 1079) {
      return null;
    }
    return (oyp)new ozo();
  }
  
  private final oyp o(int paramInt)
  {
    if (paramInt != 1080) {
      return null;
    }
    return (oyp)new ozq();
  }
  
  private final oyp p(int paramInt)
  {
    if (paramInt != 1158) {
      return null;
    }
    return (oyp)new ozd();
  }
  
  @NotNull
  public final oyp a(int paramInt, @NotNull SparseArray<oyp> paramSparseArray)
  {
    Intrinsics.checkParameterIsNotNull(paramSparseArray, "onClickListenerSparseArray");
    paramSparseArray = (oyp)paramSparseArray.get(paramInt);
    if (paramSparseArray != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CommentProteusListenerUtil", 2, "[getOnClickListener] succeed, cmdStrId = " + paramInt);
      }
      return paramSparseArray;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CommentProteusListenerUtil", 2, "[getOnClickListener] use default clickListener, cmdStrId = " + paramInt);
    }
    return ((oyq)this).a();
  }
  
  @NotNull
  public final oyq a(int paramInt, @NotNull SparseArray<oyp> paramSparseArray)
  {
    Intrinsics.checkParameterIsNotNull(paramSparseArray, "onClickListenerSparseArray");
    ((oyq)this).a(paramInt, ((oyq)this).a(paramInt), paramSparseArray);
    ((oyq)this).a(paramInt, ((oyq)this).b(paramInt), paramSparseArray);
    ((oyq)this).a(paramInt, ((oyq)this).c(paramInt), paramSparseArray);
    ((oyq)this).a(paramInt, ((oyq)this).d(paramInt), paramSparseArray);
    ((oyq)this).a(paramInt, ((oyq)this).e(paramInt), paramSparseArray);
    ((oyq)this).a(paramInt, ((oyq)this).f(paramInt), paramSparseArray);
    ((oyq)this).a(paramInt, ((oyq)this).g(paramInt), paramSparseArray);
    ((oyq)this).a(paramInt, ((oyq)this).h(paramInt), paramSparseArray);
    ((oyq)this).a(paramInt, ((oyq)this).i(paramInt), paramSparseArray);
    ((oyq)this).a(paramInt, ((oyq)this).j(paramInt), paramSparseArray);
    ((oyq)this).a(paramInt, ((oyq)this).k(paramInt), paramSparseArray);
    ((oyq)this).a(paramInt, ((oyq)this).l(paramInt), paramSparseArray);
    ((oyq)this).a(paramInt, ((oyq)this).m(paramInt), paramSparseArray);
    ((oyq)this).a(paramInt, ((oyq)this).n(paramInt), paramSparseArray);
    ((oyq)this).a(paramInt, ((oyq)this).o(paramInt), paramSparseArray);
    ((oyq)this).a(paramInt, ((oyq)this).p(paramInt), paramSparseArray);
    return (oyq)this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oyq
 * JD-Core Version:    0.7.0.1
 */