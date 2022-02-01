import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/comment/CommentProteusListenerUtil$Companion;", "", "()V", "TAG", "", "getOnClickListener", "Lcom/tencent/biz/pubaccount/readinjoy/comment/CommentProteusListenerUtil$CommentProteusOnClickListener;", "cmdStrId", "", "onClickListenerSparseArray", "Landroid/util/SparseArray;", "initAdDownloadAreaClickListener", "initAdImageAreaClickListener", "initAdItemClickListener", "initAdNameClickListener", "initAdTagClickListener", "initAdTimeAreaClickListener", "initChooseCommentTypeClickListener", "initCommentActivityClickListener", "initCommentBannerClickListener", "initCommentContentClickListener", "initCommentDotClickListener", "initCommentFlowGuideClickListener", "initCommentHideButtonClickListener", "initCommentMediaClickListener", "initCommentReplyClickListener", "initDefaultClickListener", "initDeleteCommentClickListener", "initExposeCommentClickListener", "initExposeSubCommentOneClickListener", "initExposeSubCommentTwoClickListener", "initHeadMedalClickListener", "initLikeClickListener", "initOnClickListener", "initSocialAvatarOnClickListener", "putOnClickListenerIntoSparseArray", "", "onClickListener", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class owq
{
  private final owp a()
  {
    return (owp)new oxw();
  }
  
  private final owp a(int paramInt)
  {
    if (paramInt != 1023) {
      return null;
    }
    return (owp)new oyi();
  }
  
  private final void a(int paramInt, owp paramowp, SparseArray<owp> paramSparseArray)
  {
    if (paramowp != null) {
      paramSparseArray.put(paramInt, paramowp);
    }
  }
  
  private final owp b(int paramInt)
  {
    if (paramInt != 1002) {
      return null;
    }
    return (owp)new oyh();
  }
  
  private final owp c(int paramInt)
  {
    if (paramInt != 1062) {
      return null;
    }
    return (owp)new oxf();
  }
  
  private final owp d(int paramInt)
  {
    if (paramInt != 1055) {
      return null;
    }
    return (owp)new oxu();
  }
  
  private final owp e(int paramInt)
  {
    if (paramInt != 1059) {
      return null;
    }
    return (owp)new oxy();
  }
  
  private final owp f(int paramInt)
  {
    if (paramInt != 1056) {
      return null;
    }
    return (owp)new oxl();
  }
  
  private final owp g(int paramInt)
  {
    if (paramInt != 1060) {
      return null;
    }
    return (owp)new oya();
  }
  
  private final owp h(int paramInt)
  {
    if (paramInt != 1061) {
      return null;
    }
    return (owp)new oxj();
  }
  
  private final owp i(int paramInt)
  {
    if (paramInt != 1064) {
      return null;
    }
    return (owp)new oyf();
  }
  
  private final owp j(int paramInt)
  {
    if (paramInt != 1072) {
      return null;
    }
    return (owp)new oxh();
  }
  
  private final owp k(int paramInt)
  {
    if (paramInt != 1073) {
      return null;
    }
    return (owp)new oxd();
  }
  
  private final owp l(int paramInt)
  {
    if (paramInt != 1093) {
      return null;
    }
    return (owp)new oxo();
  }
  
  private final owp m(int paramInt)
  {
    if (paramInt != 1094) {
      return null;
    }
    return (owp)new oxs();
  }
  
  private final owp n(int paramInt)
  {
    if (paramInt != 1079) {
      return null;
    }
    return (owp)new oyb();
  }
  
  private final owp o(int paramInt)
  {
    if (paramInt != 1080) {
      return null;
    }
    return (owp)new oyd();
  }
  
  private final owp p(int paramInt)
  {
    if (paramInt != 1159) {
      return null;
    }
    return (owp)new oxq();
  }
  
  private final owp q(int paramInt)
  {
    if (paramInt != 1119) {
      return null;
    }
    return (owp)new owt();
  }
  
  private final owp r(int paramInt)
  {
    if (paramInt != 1178) {
      return null;
    }
    return (owp)new owz();
  }
  
  private final owp s(int paramInt)
  {
    if (paramInt != 1179) {
      return null;
    }
    return (owp)new oxb();
  }
  
  private final owp t(int paramInt)
  {
    if (paramInt != 1180) {
      return null;
    }
    return (owp)new owx();
  }
  
  private final owp u(int paramInt)
  {
    if (paramInt != 1103) {
      return null;
    }
    return (owp)new owr();
  }
  
  private final owp v(int paramInt)
  {
    if (paramInt != 1181) {
      return null;
    }
    return (owp)new owv();
  }
  
  @NotNull
  public final owp a(int paramInt, @NotNull SparseArray<owp> paramSparseArray)
  {
    Intrinsics.checkParameterIsNotNull(paramSparseArray, "onClickListenerSparseArray");
    paramSparseArray = (owp)paramSparseArray.get(paramInt);
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
    return ((owq)this).a();
  }
  
  @NotNull
  public final owq a(int paramInt, @NotNull SparseArray<owp> paramSparseArray)
  {
    Intrinsics.checkParameterIsNotNull(paramSparseArray, "onClickListenerSparseArray");
    ((owq)this).a(paramInt, ((owq)this).a(paramInt), paramSparseArray);
    ((owq)this).a(paramInt, ((owq)this).b(paramInt), paramSparseArray);
    ((owq)this).a(paramInt, ((owq)this).c(paramInt), paramSparseArray);
    ((owq)this).a(paramInt, ((owq)this).d(paramInt), paramSparseArray);
    ((owq)this).a(paramInt, ((owq)this).e(paramInt), paramSparseArray);
    ((owq)this).a(paramInt, ((owq)this).f(paramInt), paramSparseArray);
    ((owq)this).a(paramInt, ((owq)this).g(paramInt), paramSparseArray);
    ((owq)this).a(paramInt, ((owq)this).h(paramInt), paramSparseArray);
    ((owq)this).a(paramInt, ((owq)this).i(paramInt), paramSparseArray);
    ((owq)this).a(paramInt, ((owq)this).j(paramInt), paramSparseArray);
    ((owq)this).a(paramInt, ((owq)this).k(paramInt), paramSparseArray);
    ((owq)this).a(paramInt, ((owq)this).l(paramInt), paramSparseArray);
    ((owq)this).a(paramInt, ((owq)this).m(paramInt), paramSparseArray);
    ((owq)this).a(paramInt, ((owq)this).n(paramInt), paramSparseArray);
    ((owq)this).a(paramInt, ((owq)this).o(paramInt), paramSparseArray);
    ((owq)this).a(paramInt, ((owq)this).p(paramInt), paramSparseArray);
    ((owq)this).a(paramInt, ((owq)this).q(paramInt), paramSparseArray);
    ((owq)this).a(paramInt, ((owq)this).r(paramInt), paramSparseArray);
    ((owq)this).a(paramInt, ((owq)this).s(paramInt), paramSparseArray);
    ((owq)this).a(paramInt, ((owq)this).t(paramInt), paramSparseArray);
    ((owq)this).a(paramInt, ((owq)this).u(paramInt), paramSparseArray);
    ((owq)this).a(paramInt, ((owq)this).v(paramInt), paramSparseArray);
    return (owq)this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     owq
 * JD-Core Version:    0.7.0.1
 */