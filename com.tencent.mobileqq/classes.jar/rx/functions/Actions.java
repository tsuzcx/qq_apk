package rx.functions;

public final class Actions
{
  private static final Actions.EmptyAction EMPTY_ACTION = new Actions.EmptyAction();
  
  private Actions()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static <T0, T1, T2, T3, T4, T5, T6, T7, T8> Actions.EmptyAction<T0, T1, T2, T3, T4, T5, T6, T7, T8> empty()
  {
    return EMPTY_ACTION;
  }
  
  public static Func0<Void> toFunc(Action0 paramAction0)
  {
    return toFunc(paramAction0, (Void)null);
  }
  
  public static <R> Func0<R> toFunc(Action0 paramAction0, R paramR)
  {
    return new Actions.1(paramAction0, paramR);
  }
  
  public static <T1> Func1<T1, Void> toFunc(Action1<T1> paramAction1)
  {
    return toFunc(paramAction1, (Void)null);
  }
  
  public static <T1, R> Func1<T1, R> toFunc(Action1<T1> paramAction1, R paramR)
  {
    return new Actions.2(paramAction1, paramR);
  }
  
  public static <T1, T2> Func2<T1, T2, Void> toFunc(Action2<T1, T2> paramAction2)
  {
    return toFunc(paramAction2, (Void)null);
  }
  
  public static <T1, T2, R> Func2<T1, T2, R> toFunc(Action2<T1, T2> paramAction2, R paramR)
  {
    return new Actions.3(paramAction2, paramR);
  }
  
  public static <T1, T2, T3> Func3<T1, T2, T3, Void> toFunc(Action3<T1, T2, T3> paramAction3)
  {
    return toFunc(paramAction3, (Void)null);
  }
  
  public static <T1, T2, T3, R> Func3<T1, T2, T3, R> toFunc(Action3<T1, T2, T3> paramAction3, R paramR)
  {
    return new Actions.4(paramAction3, paramR);
  }
  
  public static <T1, T2, T3, T4> Func4<T1, T2, T3, T4, Void> toFunc(Action4<T1, T2, T3, T4> paramAction4)
  {
    return toFunc(paramAction4, (Void)null);
  }
  
  public static <T1, T2, T3, T4, R> Func4<T1, T2, T3, T4, R> toFunc(Action4<T1, T2, T3, T4> paramAction4, R paramR)
  {
    return new Actions.5(paramAction4, paramR);
  }
  
  public static <T1, T2, T3, T4, T5> Func5<T1, T2, T3, T4, T5, Void> toFunc(Action5<T1, T2, T3, T4, T5> paramAction5)
  {
    return toFunc(paramAction5, (Void)null);
  }
  
  public static <T1, T2, T3, T4, T5, R> Func5<T1, T2, T3, T4, T5, R> toFunc(Action5<T1, T2, T3, T4, T5> paramAction5, R paramR)
  {
    return new Actions.6(paramAction5, paramR);
  }
  
  public static <T1, T2, T3, T4, T5, T6> Func6<T1, T2, T3, T4, T5, T6, Void> toFunc(Action6<T1, T2, T3, T4, T5, T6> paramAction6)
  {
    return toFunc(paramAction6, (Void)null);
  }
  
  public static <T1, T2, T3, T4, T5, T6, R> Func6<T1, T2, T3, T4, T5, T6, R> toFunc(Action6<T1, T2, T3, T4, T5, T6> paramAction6, R paramR)
  {
    return new Actions.7(paramAction6, paramR);
  }
  
  public static <T1, T2, T3, T4, T5, T6, T7> Func7<T1, T2, T3, T4, T5, T6, T7, Void> toFunc(Action7<T1, T2, T3, T4, T5, T6, T7> paramAction7)
  {
    return toFunc(paramAction7, (Void)null);
  }
  
  public static <T1, T2, T3, T4, T5, T6, T7, R> Func7<T1, T2, T3, T4, T5, T6, T7, R> toFunc(Action7<T1, T2, T3, T4, T5, T6, T7> paramAction7, R paramR)
  {
    return new Actions.8(paramAction7, paramR);
  }
  
  public static <T1, T2, T3, T4, T5, T6, T7, T8> Func8<T1, T2, T3, T4, T5, T6, T7, T8, Void> toFunc(Action8<T1, T2, T3, T4, T5, T6, T7, T8> paramAction8)
  {
    return toFunc(paramAction8, (Void)null);
  }
  
  public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Func8<T1, T2, T3, T4, T5, T6, T7, T8, R> toFunc(Action8<T1, T2, T3, T4, T5, T6, T7, T8> paramAction8, R paramR)
  {
    return new Actions.9(paramAction8, paramR);
  }
  
  public static <T1, T2, T3, T4, T5, T6, T7, T8, T9> Func9<T1, T2, T3, T4, T5, T6, T7, T8, T9, Void> toFunc(Action9<T1, T2, T3, T4, T5, T6, T7, T8, T9> paramAction9)
  {
    return toFunc(paramAction9, (Void)null);
  }
  
  public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Func9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> toFunc(Action9<T1, T2, T3, T4, T5, T6, T7, T8, T9> paramAction9, R paramR)
  {
    return new Actions.10(paramAction9, paramR);
  }
  
  public static FuncN<Void> toFunc(ActionN paramActionN)
  {
    return toFunc(paramActionN, (Void)null);
  }
  
  public static <R> FuncN<R> toFunc(ActionN paramActionN, R paramR)
  {
    return new Actions.11(paramActionN, paramR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.functions.Actions
 * JD-Core Version:    0.7.0.1
 */