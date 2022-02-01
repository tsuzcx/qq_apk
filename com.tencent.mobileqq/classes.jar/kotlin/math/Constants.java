package kotlin.math;

import kotlin.Metadata;
import kotlin.jvm.JvmField;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/math/Constants;", "", "()V", "LN2", "", "epsilon", "taylor_2_bound", "taylor_n_bound", "upper_taylor_2_bound", "upper_taylor_n_bound", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class Constants
{
  public static final Constants INSTANCE = new Constants();
  @JvmField
  public static final double LN2 = Math.log(2.0D);
  @JvmField
  public static final double epsilon = Math.ulp(1.0D);
  @JvmField
  public static final double taylor_2_bound = Math.sqrt(epsilon);
  @JvmField
  public static final double taylor_n_bound = Math.sqrt(taylor_2_bound);
  @JvmField
  public static final double upper_taylor_2_bound;
  @JvmField
  public static final double upper_taylor_n_bound;
  
  static
  {
    double d1 = 1;
    double d2 = taylor_2_bound;
    Double.isNaN(d1);
    upper_taylor_2_bound = d1 / d2;
    d2 = taylor_n_bound;
    Double.isNaN(d1);
    upper_taylor_n_bound = d1 / d2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.math.Constants
 * JD-Core Version:    0.7.0.1
 */