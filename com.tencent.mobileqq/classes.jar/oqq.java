import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/comment/CommentProteusListenerUtil$Companion;", "", "()V", "TAG", "", "getOnClickListener", "Lcom/tencent/biz/pubaccount/readinjoy/comment/CommentProteusListenerUtil$CommentProteusOnClickListener;", "cmdStrId", "", "onClickListenerSparseArray", "Landroid/util/SparseArray;", "initChooseCommentTypeClickListener", "initCommentActivityClickListener", "initCommentBannerClickListener", "initCommentContentClickListener", "initCommentDotClickListener", "initCommentFlowGuideClickListener", "initCommentHideButtonClickListener", "initCommentMediaClickListener", "initCommentReplyClickListener", "initDefaultClickListener", "initDeleteCommentClickListener", "initExposeCommentClickListener", "initExposeSubCommentOneClickListener", "initExposeSubCommentTwoClickListener", "initHeadMedalClickListener", "initLikeClickListener", "initOnClickListener", "initSocialAvatarOnClickListener", "putOnClickListenerIntoSparseArray", "", "onClickListener", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class oqq
{
  private final oqp a()
  {
    return (oqp)new orj();
  }
  
  private final oqp a(int paramInt)
  {
    if (paramInt != 1023) {
      return null;
    }
    return (oqp)new orv();
  }
  
  private final void a(int paramInt, oqp paramoqp, SparseArray<oqp> paramSparseArray)
  {
    if (paramoqp != null) {
      paramSparseArray.put(paramInt, paramoqp);
    }
  }
  
  private final oqp b(int paramInt)
  {
    if (paramInt != 1002) {
      return null;
    }
    return (oqp)new oru();
  }
  
  private final oqp c(int paramInt)
  {
    if (paramInt != 1062) {
      return null;
    }
    return (oqp)new oqt();
  }
  
  private final oqp d(int paramInt)
  {
    if (paramInt != 1055) {
      return null;
    }
    return (oqp)new orh();
  }
  
  private final oqp e(int paramInt)
  {
    if (paramInt != 1059) {
      return null;
    }
    return (oqp)new orl();
  }
  
  private final oqp f(int paramInt)
  {
    if (paramInt != 1056) {
      return null;
    }
    return (oqp)new oqy();
  }
  
  private final oqp g(int paramInt)
  {
    if (paramInt != 1060) {
      return null;
    }
    return (oqp)new orn();
  }
  
  private final oqp h(int paramInt)
  {
    if (paramInt != 1061) {
      return null;
    }
    return (oqp)new oqx();
  }
  
  private final oqp i(int paramInt)
  {
    if (paramInt != 1064) {
      return null;
    }
    return (oqp)new ors();
  }
  
  private final oqp j(int paramInt)
  {
    if (paramInt != 1072) {
      return null;
    }
    return (oqp)new oqv();
  }
  
  private final oqp k(int paramInt)
  {
    if (paramInt != 1073) {
      return null;
    }
    return (oqp)new oqr();
  }
  
  private final oqp l(int paramInt)
  {
    if (paramInt != 1093) {
      return null;
    }
    return (oqp)new orb();
  }
  
  private final oqp m(int paramInt)
  {
    if (paramInt != 1094) {
      return null;
    }
    return (oqp)new orf();
  }
  
  private final oqp n(int paramInt)
  {
    if (paramInt != 1079) {
      return null;
    }
    return (oqp)new oro();
  }
  
  private final oqp o(int paramInt)
  {
    if (paramInt != 1080) {
      return null;
    }
    return (oqp)new orq();
  }
  
  private final oqp p(int paramInt)
  {
    if (paramInt != 1158) {
      return null;
    }
    return (oqp)new ord();
  }
  
  @NotNull
  public final oqp a(int paramInt, @NotNull SparseArray<oqp> paramSparseArray)
  {
    Intrinsics.checkParameterIsNotNull(paramSparseArray, "onClickListenerSparseArray");
    paramSparseArray = (oqp)paramSparseArray.get(paramInt);
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
    return ((oqq)this).a();
  }
  
  @NotNull
  public final oqq a(int paramInt, @NotNull SparseArray<oqp> paramSparseArray)
  {
    Intrinsics.checkParameterIsNotNull(paramSparseArray, "onClickListenerSparseArray");
    ((oqq)this).a(paramInt, ((oqq)this).a(paramInt), paramSparseArray);
    ((oqq)this).a(paramInt, ((oqq)this).b(paramInt), paramSparseArray);
    ((oqq)this).a(paramInt, ((oqq)this).c(paramInt), paramSparseArray);
    ((oqq)this).a(paramInt, ((oqq)this).d(paramInt), paramSparseArray);
    ((oqq)this).a(paramInt, ((oqq)this).e(paramInt), paramSparseArray);
    ((oqq)this).a(paramInt, ((oqq)this).f(paramInt), paramSparseArray);
    ((oqq)this).a(paramInt, ((oqq)this).g(paramInt), paramSparseArray);
    ((oqq)this).a(paramInt, ((oqq)this).h(paramInt), paramSparseArray);
    ((oqq)this).a(paramInt, ((oqq)this).i(paramInt), paramSparseArray);
    ((oqq)this).a(paramInt, ((oqq)this).j(paramInt), paramSparseArray);
    ((oqq)this).a(paramInt, ((oqq)this).k(paramInt), paramSparseArray);
    ((oqq)this).a(paramInt, ((oqq)this).l(paramInt), paramSparseArray);
    ((oqq)this).a(paramInt, ((oqq)this).m(paramInt), paramSparseArray);
    ((oqq)this).a(paramInt, ((oqq)this).n(paramInt), paramSparseArray);
    ((oqq)this).a(paramInt, ((oqq)this).o(paramInt), paramSparseArray);
    ((oqq)this).a(paramInt, ((oqq)this).p(paramInt), paramSparseArray);
    return (oqq)this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oqq
 * JD-Core Version:    0.7.0.1
 */