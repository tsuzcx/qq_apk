import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public final class gy
{
  private static final gy[] jdField_a_of_type_ArrayOfGy = ;
  private final int jdField_a_of_type_Int;
  private final ha[] jdField_a_of_type_ArrayOfHa;
  private final int b;
  
  private gy(int paramInt, int[] paramArrayOfInt, ha... paramVarArgs)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ArrayOfHa = paramVarArgs;
    int k = paramVarArgs[0].a();
    paramArrayOfInt = paramVarArgs[0].a();
    int m = paramArrayOfInt.length;
    int i = 0;
    paramInt = j;
    while (paramInt < m)
    {
      paramVarArgs = paramArrayOfInt[paramInt];
      j = paramVarArgs.a();
      i += (paramVarArgs.b() + k) * j;
      paramInt += 1;
    }
    this.b = i;
  }
  
  public static gy a(int paramInt)
  {
    if ((paramInt < 1) || (paramInt > 40)) {
      throw new IllegalArgumentException();
    }
    return jdField_a_of_type_ArrayOfGy[(paramInt - 1)];
  }
  
  private static gy[] a()
  {
    Object localObject1 = new ha(7, new gz[] { new gz(1, 19) });
    Object localObject2 = new ha(10, new gz[] { new gz(1, 16) });
    Object localObject3 = new ha(13, new gz[] { new gz(1, 13) });
    Object localObject4 = new ha(17, new gz[] { new gz(1, 9) });
    localObject1 = new gy(1, new int[0], new ha[] { localObject1, localObject2, localObject3, localObject4 });
    localObject2 = new ha(10, new gz[] { new gz(1, 34) });
    localObject3 = new ha(16, new gz[] { new gz(1, 28) });
    localObject4 = new ha(22, new gz[] { new gz(1, 22) });
    Object localObject5 = new ha(28, new gz[] { new gz(1, 16) });
    localObject2 = new gy(2, new int[] { 6, 18 }, new ha[] { localObject2, localObject3, localObject4, localObject5 });
    localObject3 = new ha(15, new gz[] { new gz(1, 55) });
    localObject4 = new ha(26, new gz[] { new gz(1, 44) });
    localObject5 = new ha(18, new gz[] { new gz(2, 17) });
    Object localObject6 = new ha(22, new gz[] { new gz(2, 13) });
    localObject3 = new gy(3, new int[] { 6, 22 }, new ha[] { localObject3, localObject4, localObject5, localObject6 });
    localObject4 = new ha(20, new gz[] { new gz(1, 80) });
    localObject5 = new ha(18, new gz[] { new gz(2, 32) });
    localObject6 = new ha(26, new gz[] { new gz(2, 24) });
    Object localObject7 = new ha(16, new gz[] { new gz(4, 9) });
    localObject4 = new gy(4, new int[] { 6, 26 }, new ha[] { localObject4, localObject5, localObject6, localObject7 });
    localObject5 = new ha(26, new gz[] { new gz(1, 108) });
    localObject6 = new ha(24, new gz[] { new gz(2, 43) });
    localObject7 = new ha(18, new gz[] { new gz(2, 15), new gz(2, 16) });
    Object localObject8 = new ha(22, new gz[] { new gz(2, 11), new gz(2, 12) });
    localObject5 = new gy(5, new int[] { 6, 30 }, new ha[] { localObject5, localObject6, localObject7, localObject8 });
    localObject6 = new ha(18, new gz[] { new gz(2, 68) });
    localObject7 = new ha(16, new gz[] { new gz(4, 27) });
    localObject8 = new ha(24, new gz[] { new gz(4, 19) });
    Object localObject9 = new ha(28, new gz[] { new gz(4, 15) });
    localObject6 = new gy(6, new int[] { 6, 34 }, new ha[] { localObject6, localObject7, localObject8, localObject9 });
    localObject7 = new ha(20, new gz[] { new gz(2, 78) });
    localObject8 = new ha(18, new gz[] { new gz(4, 31) });
    localObject9 = new ha(18, new gz[] { new gz(2, 14), new gz(4, 15) });
    Object localObject10 = new ha(26, new gz[] { new gz(4, 13), new gz(1, 14) });
    localObject7 = new gy(7, new int[] { 6, 22, 38 }, new ha[] { localObject7, localObject8, localObject9, localObject10 });
    localObject8 = new ha(24, new gz[] { new gz(2, 97) });
    localObject9 = new ha(22, new gz[] { new gz(2, 38), new gz(2, 39) });
    localObject10 = new ha(22, new gz[] { new gz(4, 18), new gz(2, 19) });
    Object localObject11 = new ha(26, new gz[] { new gz(4, 14), new gz(2, 15) });
    localObject8 = new gy(8, new int[] { 6, 24, 42 }, new ha[] { localObject8, localObject9, localObject10, localObject11 });
    localObject9 = new ha(30, new gz[] { new gz(2, 116) });
    localObject10 = new ha(22, new gz[] { new gz(3, 36), new gz(2, 37) });
    localObject11 = new ha(20, new gz[] { new gz(4, 16), new gz(4, 17) });
    Object localObject12 = new ha(24, new gz[] { new gz(4, 12), new gz(4, 13) });
    localObject9 = new gy(9, new int[] { 6, 26, 46 }, new ha[] { localObject9, localObject10, localObject11, localObject12 });
    localObject10 = new ha(18, new gz[] { new gz(2, 68), new gz(2, 69) });
    localObject11 = new ha(26, new gz[] { new gz(4, 43), new gz(1, 44) });
    localObject12 = new ha(24, new gz[] { new gz(6, 19), new gz(2, 20) });
    Object localObject13 = new ha(28, new gz[] { new gz(6, 15), new gz(2, 16) });
    localObject10 = new gy(10, new int[] { 6, 28, 50 }, new ha[] { localObject10, localObject11, localObject12, localObject13 });
    localObject11 = new ha(20, new gz[] { new gz(4, 81) });
    localObject12 = new ha(30, new gz[] { new gz(1, 50), new gz(4, 51) });
    localObject13 = new ha(28, new gz[] { new gz(4, 22), new gz(4, 23) });
    Object localObject14 = new ha(24, new gz[] { new gz(3, 12), new gz(8, 13) });
    localObject11 = new gy(11, new int[] { 6, 30, 54 }, new ha[] { localObject11, localObject12, localObject13, localObject14 });
    localObject12 = new ha(24, new gz[] { new gz(2, 92), new gz(2, 93) });
    localObject13 = new ha(22, new gz[] { new gz(6, 36), new gz(2, 37) });
    localObject14 = new ha(26, new gz[] { new gz(4, 20), new gz(6, 21) });
    Object localObject15 = new ha(28, new gz[] { new gz(7, 14), new gz(4, 15) });
    localObject12 = new gy(12, new int[] { 6, 32, 58 }, new ha[] { localObject12, localObject13, localObject14, localObject15 });
    localObject13 = new ha(26, new gz[] { new gz(4, 107) });
    localObject14 = new ha(22, new gz[] { new gz(8, 37), new gz(1, 38) });
    localObject15 = new ha(24, new gz[] { new gz(8, 20), new gz(4, 21) });
    Object localObject16 = new ha(22, new gz[] { new gz(12, 11), new gz(4, 12) });
    localObject13 = new gy(13, new int[] { 6, 34, 62 }, new ha[] { localObject13, localObject14, localObject15, localObject16 });
    localObject14 = new ha(30, new gz[] { new gz(3, 115), new gz(1, 116) });
    localObject15 = new ha(24, new gz[] { new gz(4, 40), new gz(5, 41) });
    localObject16 = new ha(20, new gz[] { new gz(11, 16), new gz(5, 17) });
    Object localObject17 = new ha(24, new gz[] { new gz(11, 12), new gz(5, 13) });
    localObject14 = new gy(14, new int[] { 6, 26, 46, 66 }, new ha[] { localObject14, localObject15, localObject16, localObject17 });
    localObject15 = new ha(22, new gz[] { new gz(5, 87), new gz(1, 88) });
    localObject16 = new ha(24, new gz[] { new gz(5, 41), new gz(5, 42) });
    localObject17 = new ha(30, new gz[] { new gz(5, 24), new gz(7, 25) });
    Object localObject18 = new ha(24, new gz[] { new gz(11, 12), new gz(7, 13) });
    localObject15 = new gy(15, new int[] { 6, 26, 48, 70 }, new ha[] { localObject15, localObject16, localObject17, localObject18 });
    localObject16 = new ha(24, new gz[] { new gz(5, 98), new gz(1, 99) });
    localObject17 = new ha(28, new gz[] { new gz(7, 45), new gz(3, 46) });
    localObject18 = new ha(24, new gz[] { new gz(15, 19), new gz(2, 20) });
    Object localObject19 = new ha(30, new gz[] { new gz(3, 15), new gz(13, 16) });
    localObject16 = new gy(16, new int[] { 6, 26, 50, 74 }, new ha[] { localObject16, localObject17, localObject18, localObject19 });
    localObject17 = new ha(28, new gz[] { new gz(1, 107), new gz(5, 108) });
    localObject18 = new ha(28, new gz[] { new gz(10, 46), new gz(1, 47) });
    localObject19 = new ha(28, new gz[] { new gz(1, 22), new gz(15, 23) });
    Object localObject20 = new ha(28, new gz[] { new gz(2, 14), new gz(17, 15) });
    localObject17 = new gy(17, new int[] { 6, 30, 54, 78 }, new ha[] { localObject17, localObject18, localObject19, localObject20 });
    localObject18 = new ha(30, new gz[] { new gz(5, 120), new gz(1, 121) });
    localObject19 = new ha(26, new gz[] { new gz(9, 43), new gz(4, 44) });
    localObject20 = new ha(28, new gz[] { new gz(17, 22), new gz(1, 23) });
    Object localObject21 = new ha(28, new gz[] { new gz(2, 14), new gz(19, 15) });
    localObject18 = new gy(18, new int[] { 6, 30, 56, 82 }, new ha[] { localObject18, localObject19, localObject20, localObject21 });
    localObject19 = new ha(28, new gz[] { new gz(3, 113), new gz(4, 114) });
    localObject20 = new ha(26, new gz[] { new gz(3, 44), new gz(11, 45) });
    localObject21 = new ha(26, new gz[] { new gz(17, 21), new gz(4, 22) });
    Object localObject22 = new ha(26, new gz[] { new gz(9, 13), new gz(16, 14) });
    localObject19 = new gy(19, new int[] { 6, 30, 58, 86 }, new ha[] { localObject19, localObject20, localObject21, localObject22 });
    localObject20 = new ha(28, new gz[] { new gz(3, 107), new gz(5, 108) });
    localObject21 = new ha(26, new gz[] { new gz(3, 41), new gz(13, 42) });
    localObject22 = new ha(30, new gz[] { new gz(15, 24), new gz(5, 25) });
    Object localObject23 = new ha(28, new gz[] { new gz(15, 15), new gz(10, 16) });
    localObject20 = new gy(20, new int[] { 6, 34, 62, 90 }, new ha[] { localObject20, localObject21, localObject22, localObject23 });
    localObject21 = new ha(28, new gz[] { new gz(4, 116), new gz(4, 117) });
    localObject22 = new ha(26, new gz[] { new gz(17, 42) });
    localObject23 = new ha(28, new gz[] { new gz(17, 22), new gz(6, 23) });
    Object localObject24 = new ha(30, new gz[] { new gz(19, 16), new gz(6, 17) });
    localObject21 = new gy(21, new int[] { 6, 28, 50, 72, 94 }, new ha[] { localObject21, localObject22, localObject23, localObject24 });
    localObject22 = new ha(28, new gz[] { new gz(2, 111), new gz(7, 112) });
    localObject23 = new ha(28, new gz[] { new gz(17, 46) });
    localObject24 = new ha(30, new gz[] { new gz(7, 24), new gz(16, 25) });
    Object localObject25 = new ha(24, new gz[] { new gz(34, 13) });
    localObject22 = new gy(22, new int[] { 6, 26, 50, 74, 98 }, new ha[] { localObject22, localObject23, localObject24, localObject25 });
    localObject23 = new ha(30, new gz[] { new gz(4, 121), new gz(5, 122) });
    localObject24 = new ha(28, new gz[] { new gz(4, 47), new gz(14, 48) });
    localObject25 = new ha(30, new gz[] { new gz(11, 24), new gz(14, 25) });
    Object localObject26 = new ha(30, new gz[] { new gz(16, 15), new gz(14, 16) });
    localObject23 = new gy(23, new int[] { 6, 30, 54, 78, 102 }, new ha[] { localObject23, localObject24, localObject25, localObject26 });
    localObject24 = new ha(30, new gz[] { new gz(6, 117), new gz(4, 118) });
    localObject25 = new ha(28, new gz[] { new gz(6, 45), new gz(14, 46) });
    localObject26 = new ha(30, new gz[] { new gz(11, 24), new gz(16, 25) });
    Object localObject27 = new ha(30, new gz[] { new gz(30, 16), new gz(2, 17) });
    localObject24 = new gy(24, new int[] { 6, 28, 54, 80, 106 }, new ha[] { localObject24, localObject25, localObject26, localObject27 });
    localObject25 = new ha(26, new gz[] { new gz(8, 106), new gz(4, 107) });
    localObject26 = new ha(28, new gz[] { new gz(8, 47), new gz(13, 48) });
    localObject27 = new ha(30, new gz[] { new gz(7, 24), new gz(22, 25) });
    Object localObject28 = new ha(30, new gz[] { new gz(22, 15), new gz(13, 16) });
    localObject25 = new gy(25, new int[] { 6, 32, 58, 84, 110 }, new ha[] { localObject25, localObject26, localObject27, localObject28 });
    localObject26 = new ha(28, new gz[] { new gz(10, 114), new gz(2, 115) });
    localObject27 = new ha(28, new gz[] { new gz(19, 46), new gz(4, 47) });
    localObject28 = new ha(28, new gz[] { new gz(28, 22), new gz(6, 23) });
    Object localObject29 = new ha(30, new gz[] { new gz(33, 16), new gz(4, 17) });
    localObject26 = new gy(26, new int[] { 6, 30, 58, 86, 114 }, new ha[] { localObject26, localObject27, localObject28, localObject29 });
    localObject27 = new ha(30, new gz[] { new gz(8, 122), new gz(4, 123) });
    localObject28 = new ha(28, new gz[] { new gz(22, 45), new gz(3, 46) });
    localObject29 = new ha(30, new gz[] { new gz(8, 23), new gz(26, 24) });
    Object localObject30 = new ha(30, new gz[] { new gz(12, 15), new gz(28, 16) });
    localObject27 = new gy(27, new int[] { 6, 34, 62, 90, 118 }, new ha[] { localObject27, localObject28, localObject29, localObject30 });
    localObject28 = new ha(30, new gz[] { new gz(3, 117), new gz(10, 118) });
    localObject29 = new ha(28, new gz[] { new gz(3, 45), new gz(23, 46) });
    localObject30 = new ha(30, new gz[] { new gz(4, 24), new gz(31, 25) });
    Object localObject31 = new ha(30, new gz[] { new gz(11, 15), new gz(31, 16) });
    localObject28 = new gy(28, new int[] { 6, 26, 50, 74, 98, 122 }, new ha[] { localObject28, localObject29, localObject30, localObject31 });
    localObject29 = new ha(30, new gz[] { new gz(7, 116), new gz(7, 117) });
    localObject30 = new ha(28, new gz[] { new gz(21, 45), new gz(7, 46) });
    localObject31 = new ha(30, new gz[] { new gz(1, 23), new gz(37, 24) });
    Object localObject32 = new ha(30, new gz[] { new gz(19, 15), new gz(26, 16) });
    localObject29 = new gy(29, new int[] { 6, 30, 54, 78, 102, 126 }, new ha[] { localObject29, localObject30, localObject31, localObject32 });
    localObject30 = new ha(30, new gz[] { new gz(5, 115), new gz(10, 116) });
    localObject31 = new ha(28, new gz[] { new gz(19, 47), new gz(10, 48) });
    localObject32 = new ha(30, new gz[] { new gz(15, 24), new gz(25, 25) });
    Object localObject33 = new ha(30, new gz[] { new gz(23, 15), new gz(25, 16) });
    localObject30 = new gy(30, new int[] { 6, 26, 52, 78, 104, 130 }, new ha[] { localObject30, localObject31, localObject32, localObject33 });
    localObject31 = new ha(30, new gz[] { new gz(13, 115), new gz(3, 116) });
    localObject32 = new ha(28, new gz[] { new gz(2, 46), new gz(29, 47) });
    localObject33 = new ha(30, new gz[] { new gz(42, 24), new gz(1, 25) });
    Object localObject34 = new ha(30, new gz[] { new gz(23, 15), new gz(28, 16) });
    localObject31 = new gy(31, new int[] { 6, 30, 56, 82, 108, 134 }, new ha[] { localObject31, localObject32, localObject33, localObject34 });
    localObject32 = new ha(30, new gz[] { new gz(17, 115) });
    localObject33 = new ha(28, new gz[] { new gz(10, 46), new gz(23, 47) });
    localObject34 = new ha(30, new gz[] { new gz(10, 24), new gz(35, 25) });
    Object localObject35 = new ha(30, new gz[] { new gz(19, 15), new gz(35, 16) });
    localObject32 = new gy(32, new int[] { 6, 34, 60, 86, 112, 138 }, new ha[] { localObject32, localObject33, localObject34, localObject35 });
    localObject33 = new ha(30, new gz[] { new gz(17, 115), new gz(1, 116) });
    localObject34 = new ha(28, new gz[] { new gz(14, 46), new gz(21, 47) });
    localObject35 = new ha(30, new gz[] { new gz(29, 24), new gz(19, 25) });
    Object localObject36 = new ha(30, new gz[] { new gz(11, 15), new gz(46, 16) });
    localObject33 = new gy(33, new int[] { 6, 30, 58, 86, 114, 142 }, new ha[] { localObject33, localObject34, localObject35, localObject36 });
    localObject34 = new ha(30, new gz[] { new gz(13, 115), new gz(6, 116) });
    localObject35 = new ha(28, new gz[] { new gz(14, 46), new gz(23, 47) });
    localObject36 = new ha(30, new gz[] { new gz(44, 24), new gz(7, 25) });
    Object localObject37 = new ha(30, new gz[] { new gz(59, 16), new gz(1, 17) });
    localObject34 = new gy(34, new int[] { 6, 34, 62, 90, 118, 146 }, new ha[] { localObject34, localObject35, localObject36, localObject37 });
    localObject35 = new ha(30, new gz[] { new gz(12, 121), new gz(7, 122) });
    localObject36 = new ha(28, new gz[] { new gz(12, 47), new gz(26, 48) });
    localObject37 = new ha(30, new gz[] { new gz(39, 24), new gz(14, 25) });
    Object localObject38 = new ha(30, new gz[] { new gz(22, 15), new gz(41, 16) });
    localObject35 = new gy(35, new int[] { 6, 30, 54, 78, 102, 126, 150 }, new ha[] { localObject35, localObject36, localObject37, localObject38 });
    localObject36 = new ha(30, new gz[] { new gz(6, 121), new gz(14, 122) });
    localObject37 = new ha(28, new gz[] { new gz(6, 47), new gz(34, 48) });
    localObject38 = new ha(30, new gz[] { new gz(46, 24), new gz(10, 25) });
    Object localObject39 = new ha(30, new gz[] { new gz(2, 15), new gz(64, 16) });
    localObject36 = new gy(36, new int[] { 6, 24, 50, 76, 102, 128, 154 }, new ha[] { localObject36, localObject37, localObject38, localObject39 });
    localObject37 = new ha(30, new gz[] { new gz(17, 122), new gz(4, 123) });
    localObject38 = new ha(28, new gz[] { new gz(29, 46), new gz(14, 47) });
    localObject39 = new ha(30, new gz[] { new gz(49, 24), new gz(10, 25) });
    ha localha1 = new ha(30, new gz[] { new gz(24, 15), new gz(46, 16) });
    localObject37 = new gy(37, new int[] { 6, 28, 54, 80, 106, 132, 158 }, new ha[] { localObject37, localObject38, localObject39, localha1 });
    localObject38 = new ha(30, new gz[] { new gz(4, 122), new gz(18, 123) });
    localObject39 = new ha(28, new gz[] { new gz(13, 46), new gz(32, 47) });
    localha1 = new ha(30, new gz[] { new gz(48, 24), new gz(14, 25) });
    ha localha2 = new ha(30, new gz[] { new gz(42, 15), new gz(32, 16) });
    localObject38 = new gy(38, new int[] { 6, 32, 58, 84, 110, 136, 162 }, new ha[] { localObject38, localObject39, localha1, localha2 });
    localObject39 = new ha(30, new gz[] { new gz(20, 117), new gz(4, 118) });
    localha1 = new ha(28, new gz[] { new gz(40, 47), new gz(7, 48) });
    localha2 = new ha(30, new gz[] { new gz(43, 24), new gz(22, 25) });
    ha localha3 = new ha(30, new gz[] { new gz(10, 15), new gz(67, 16) });
    localObject39 = new gy(39, new int[] { 6, 26, 54, 82, 110, 138, 166 }, new ha[] { localObject39, localha1, localha2, localha3 });
    localha1 = new ha(30, new gz[] { new gz(19, 118), new gz(6, 119) });
    localha2 = new ha(28, new gz[] { new gz(18, 47), new gz(31, 48) });
    localha3 = new ha(30, new gz[] { new gz(34, 24), new gz(34, 25) });
    ha localha4 = new ha(30, new gz[] { new gz(20, 15), new gz(61, 16) });
    return new gy[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, localObject8, localObject9, localObject10, localObject11, localObject12, localObject13, localObject14, localObject15, localObject16, localObject17, localObject18, localObject19, localObject20, localObject21, localObject22, localObject23, localObject24, localObject25, localObject26, localObject27, localObject28, localObject29, localObject30, localObject31, localObject32, localObject33, localObject34, localObject35, localObject36, localObject37, localObject38, localObject39, new gy(40, new int[] { 6, 30, 58, 86, 114, 142, 170 }, new ha[] { localha1, localha2, localha3, localha4 }) };
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public ha a(ErrorCorrectionLevel paramErrorCorrectionLevel)
  {
    return this.jdField_a_of_type_ArrayOfHa[paramErrorCorrectionLevel.ordinal()];
  }
  
  public int b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int * 4 + 17;
  }
  
  public String toString()
  {
    return String.valueOf(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     gy
 * JD-Core Version:    0.7.0.1
 */