import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public final class gv
{
  private static final gv[] jdField_a_of_type_ArrayOfGv = ;
  private final int jdField_a_of_type_Int;
  private final gx[] jdField_a_of_type_ArrayOfGx;
  private final int b;
  
  private gv(int paramInt, int[] paramArrayOfInt, gx... paramVarArgs)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ArrayOfGx = paramVarArgs;
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
  
  public static gv a(int paramInt)
  {
    if ((paramInt < 1) || (paramInt > 40)) {
      throw new IllegalArgumentException();
    }
    return jdField_a_of_type_ArrayOfGv[(paramInt - 1)];
  }
  
  private static gv[] a()
  {
    Object localObject1 = new gx(7, new gw[] { new gw(1, 19) });
    Object localObject2 = new gx(10, new gw[] { new gw(1, 16) });
    Object localObject3 = new gx(13, new gw[] { new gw(1, 13) });
    Object localObject4 = new gx(17, new gw[] { new gw(1, 9) });
    localObject1 = new gv(1, new int[0], new gx[] { localObject1, localObject2, localObject3, localObject4 });
    localObject2 = new gx(10, new gw[] { new gw(1, 34) });
    localObject3 = new gx(16, new gw[] { new gw(1, 28) });
    localObject4 = new gx(22, new gw[] { new gw(1, 22) });
    Object localObject5 = new gx(28, new gw[] { new gw(1, 16) });
    localObject2 = new gv(2, new int[] { 6, 18 }, new gx[] { localObject2, localObject3, localObject4, localObject5 });
    localObject3 = new gx(15, new gw[] { new gw(1, 55) });
    localObject4 = new gx(26, new gw[] { new gw(1, 44) });
    localObject5 = new gx(18, new gw[] { new gw(2, 17) });
    Object localObject6 = new gx(22, new gw[] { new gw(2, 13) });
    localObject3 = new gv(3, new int[] { 6, 22 }, new gx[] { localObject3, localObject4, localObject5, localObject6 });
    localObject4 = new gx(20, new gw[] { new gw(1, 80) });
    localObject5 = new gx(18, new gw[] { new gw(2, 32) });
    localObject6 = new gx(26, new gw[] { new gw(2, 24) });
    Object localObject7 = new gx(16, new gw[] { new gw(4, 9) });
    localObject4 = new gv(4, new int[] { 6, 26 }, new gx[] { localObject4, localObject5, localObject6, localObject7 });
    localObject5 = new gx(26, new gw[] { new gw(1, 108) });
    localObject6 = new gx(24, new gw[] { new gw(2, 43) });
    localObject7 = new gx(18, new gw[] { new gw(2, 15), new gw(2, 16) });
    Object localObject8 = new gx(22, new gw[] { new gw(2, 11), new gw(2, 12) });
    localObject5 = new gv(5, new int[] { 6, 30 }, new gx[] { localObject5, localObject6, localObject7, localObject8 });
    localObject6 = new gx(18, new gw[] { new gw(2, 68) });
    localObject7 = new gx(16, new gw[] { new gw(4, 27) });
    localObject8 = new gx(24, new gw[] { new gw(4, 19) });
    Object localObject9 = new gx(28, new gw[] { new gw(4, 15) });
    localObject6 = new gv(6, new int[] { 6, 34 }, new gx[] { localObject6, localObject7, localObject8, localObject9 });
    localObject7 = new gx(20, new gw[] { new gw(2, 78) });
    localObject8 = new gx(18, new gw[] { new gw(4, 31) });
    localObject9 = new gx(18, new gw[] { new gw(2, 14), new gw(4, 15) });
    Object localObject10 = new gx(26, new gw[] { new gw(4, 13), new gw(1, 14) });
    localObject7 = new gv(7, new int[] { 6, 22, 38 }, new gx[] { localObject7, localObject8, localObject9, localObject10 });
    localObject8 = new gx(24, new gw[] { new gw(2, 97) });
    localObject9 = new gx(22, new gw[] { new gw(2, 38), new gw(2, 39) });
    localObject10 = new gx(22, new gw[] { new gw(4, 18), new gw(2, 19) });
    Object localObject11 = new gx(26, new gw[] { new gw(4, 14), new gw(2, 15) });
    localObject8 = new gv(8, new int[] { 6, 24, 42 }, new gx[] { localObject8, localObject9, localObject10, localObject11 });
    localObject9 = new gx(30, new gw[] { new gw(2, 116) });
    localObject10 = new gx(22, new gw[] { new gw(3, 36), new gw(2, 37) });
    localObject11 = new gx(20, new gw[] { new gw(4, 16), new gw(4, 17) });
    Object localObject12 = new gx(24, new gw[] { new gw(4, 12), new gw(4, 13) });
    localObject9 = new gv(9, new int[] { 6, 26, 46 }, new gx[] { localObject9, localObject10, localObject11, localObject12 });
    localObject10 = new gx(18, new gw[] { new gw(2, 68), new gw(2, 69) });
    localObject11 = new gx(26, new gw[] { new gw(4, 43), new gw(1, 44) });
    localObject12 = new gx(24, new gw[] { new gw(6, 19), new gw(2, 20) });
    Object localObject13 = new gx(28, new gw[] { new gw(6, 15), new gw(2, 16) });
    localObject10 = new gv(10, new int[] { 6, 28, 50 }, new gx[] { localObject10, localObject11, localObject12, localObject13 });
    localObject11 = new gx(20, new gw[] { new gw(4, 81) });
    localObject12 = new gx(30, new gw[] { new gw(1, 50), new gw(4, 51) });
    localObject13 = new gx(28, new gw[] { new gw(4, 22), new gw(4, 23) });
    Object localObject14 = new gx(24, new gw[] { new gw(3, 12), new gw(8, 13) });
    localObject11 = new gv(11, new int[] { 6, 30, 54 }, new gx[] { localObject11, localObject12, localObject13, localObject14 });
    localObject12 = new gx(24, new gw[] { new gw(2, 92), new gw(2, 93) });
    localObject13 = new gx(22, new gw[] { new gw(6, 36), new gw(2, 37) });
    localObject14 = new gx(26, new gw[] { new gw(4, 20), new gw(6, 21) });
    Object localObject15 = new gx(28, new gw[] { new gw(7, 14), new gw(4, 15) });
    localObject12 = new gv(12, new int[] { 6, 32, 58 }, new gx[] { localObject12, localObject13, localObject14, localObject15 });
    localObject13 = new gx(26, new gw[] { new gw(4, 107) });
    localObject14 = new gx(22, new gw[] { new gw(8, 37), new gw(1, 38) });
    localObject15 = new gx(24, new gw[] { new gw(8, 20), new gw(4, 21) });
    Object localObject16 = new gx(22, new gw[] { new gw(12, 11), new gw(4, 12) });
    localObject13 = new gv(13, new int[] { 6, 34, 62 }, new gx[] { localObject13, localObject14, localObject15, localObject16 });
    localObject14 = new gx(30, new gw[] { new gw(3, 115), new gw(1, 116) });
    localObject15 = new gx(24, new gw[] { new gw(4, 40), new gw(5, 41) });
    localObject16 = new gx(20, new gw[] { new gw(11, 16), new gw(5, 17) });
    Object localObject17 = new gx(24, new gw[] { new gw(11, 12), new gw(5, 13) });
    localObject14 = new gv(14, new int[] { 6, 26, 46, 66 }, new gx[] { localObject14, localObject15, localObject16, localObject17 });
    localObject15 = new gx(22, new gw[] { new gw(5, 87), new gw(1, 88) });
    localObject16 = new gx(24, new gw[] { new gw(5, 41), new gw(5, 42) });
    localObject17 = new gx(30, new gw[] { new gw(5, 24), new gw(7, 25) });
    Object localObject18 = new gx(24, new gw[] { new gw(11, 12), new gw(7, 13) });
    localObject15 = new gv(15, new int[] { 6, 26, 48, 70 }, new gx[] { localObject15, localObject16, localObject17, localObject18 });
    localObject16 = new gx(24, new gw[] { new gw(5, 98), new gw(1, 99) });
    localObject17 = new gx(28, new gw[] { new gw(7, 45), new gw(3, 46) });
    localObject18 = new gx(24, new gw[] { new gw(15, 19), new gw(2, 20) });
    Object localObject19 = new gx(30, new gw[] { new gw(3, 15), new gw(13, 16) });
    localObject16 = new gv(16, new int[] { 6, 26, 50, 74 }, new gx[] { localObject16, localObject17, localObject18, localObject19 });
    localObject17 = new gx(28, new gw[] { new gw(1, 107), new gw(5, 108) });
    localObject18 = new gx(28, new gw[] { new gw(10, 46), new gw(1, 47) });
    localObject19 = new gx(28, new gw[] { new gw(1, 22), new gw(15, 23) });
    Object localObject20 = new gx(28, new gw[] { new gw(2, 14), new gw(17, 15) });
    localObject17 = new gv(17, new int[] { 6, 30, 54, 78 }, new gx[] { localObject17, localObject18, localObject19, localObject20 });
    localObject18 = new gx(30, new gw[] { new gw(5, 120), new gw(1, 121) });
    localObject19 = new gx(26, new gw[] { new gw(9, 43), new gw(4, 44) });
    localObject20 = new gx(28, new gw[] { new gw(17, 22), new gw(1, 23) });
    Object localObject21 = new gx(28, new gw[] { new gw(2, 14), new gw(19, 15) });
    localObject18 = new gv(18, new int[] { 6, 30, 56, 82 }, new gx[] { localObject18, localObject19, localObject20, localObject21 });
    localObject19 = new gx(28, new gw[] { new gw(3, 113), new gw(4, 114) });
    localObject20 = new gx(26, new gw[] { new gw(3, 44), new gw(11, 45) });
    localObject21 = new gx(26, new gw[] { new gw(17, 21), new gw(4, 22) });
    Object localObject22 = new gx(26, new gw[] { new gw(9, 13), new gw(16, 14) });
    localObject19 = new gv(19, new int[] { 6, 30, 58, 86 }, new gx[] { localObject19, localObject20, localObject21, localObject22 });
    localObject20 = new gx(28, new gw[] { new gw(3, 107), new gw(5, 108) });
    localObject21 = new gx(26, new gw[] { new gw(3, 41), new gw(13, 42) });
    localObject22 = new gx(30, new gw[] { new gw(15, 24), new gw(5, 25) });
    Object localObject23 = new gx(28, new gw[] { new gw(15, 15), new gw(10, 16) });
    localObject20 = new gv(20, new int[] { 6, 34, 62, 90 }, new gx[] { localObject20, localObject21, localObject22, localObject23 });
    localObject21 = new gx(28, new gw[] { new gw(4, 116), new gw(4, 117) });
    localObject22 = new gx(26, new gw[] { new gw(17, 42) });
    localObject23 = new gx(28, new gw[] { new gw(17, 22), new gw(6, 23) });
    Object localObject24 = new gx(30, new gw[] { new gw(19, 16), new gw(6, 17) });
    localObject21 = new gv(21, new int[] { 6, 28, 50, 72, 94 }, new gx[] { localObject21, localObject22, localObject23, localObject24 });
    localObject22 = new gx(28, new gw[] { new gw(2, 111), new gw(7, 112) });
    localObject23 = new gx(28, new gw[] { new gw(17, 46) });
    localObject24 = new gx(30, new gw[] { new gw(7, 24), new gw(16, 25) });
    Object localObject25 = new gx(24, new gw[] { new gw(34, 13) });
    localObject22 = new gv(22, new int[] { 6, 26, 50, 74, 98 }, new gx[] { localObject22, localObject23, localObject24, localObject25 });
    localObject23 = new gx(30, new gw[] { new gw(4, 121), new gw(5, 122) });
    localObject24 = new gx(28, new gw[] { new gw(4, 47), new gw(14, 48) });
    localObject25 = new gx(30, new gw[] { new gw(11, 24), new gw(14, 25) });
    Object localObject26 = new gx(30, new gw[] { new gw(16, 15), new gw(14, 16) });
    localObject23 = new gv(23, new int[] { 6, 30, 54, 78, 102 }, new gx[] { localObject23, localObject24, localObject25, localObject26 });
    localObject24 = new gx(30, new gw[] { new gw(6, 117), new gw(4, 118) });
    localObject25 = new gx(28, new gw[] { new gw(6, 45), new gw(14, 46) });
    localObject26 = new gx(30, new gw[] { new gw(11, 24), new gw(16, 25) });
    Object localObject27 = new gx(30, new gw[] { new gw(30, 16), new gw(2, 17) });
    localObject24 = new gv(24, new int[] { 6, 28, 54, 80, 106 }, new gx[] { localObject24, localObject25, localObject26, localObject27 });
    localObject25 = new gx(26, new gw[] { new gw(8, 106), new gw(4, 107) });
    localObject26 = new gx(28, new gw[] { new gw(8, 47), new gw(13, 48) });
    localObject27 = new gx(30, new gw[] { new gw(7, 24), new gw(22, 25) });
    Object localObject28 = new gx(30, new gw[] { new gw(22, 15), new gw(13, 16) });
    localObject25 = new gv(25, new int[] { 6, 32, 58, 84, 110 }, new gx[] { localObject25, localObject26, localObject27, localObject28 });
    localObject26 = new gx(28, new gw[] { new gw(10, 114), new gw(2, 115) });
    localObject27 = new gx(28, new gw[] { new gw(19, 46), new gw(4, 47) });
    localObject28 = new gx(28, new gw[] { new gw(28, 22), new gw(6, 23) });
    Object localObject29 = new gx(30, new gw[] { new gw(33, 16), new gw(4, 17) });
    localObject26 = new gv(26, new int[] { 6, 30, 58, 86, 114 }, new gx[] { localObject26, localObject27, localObject28, localObject29 });
    localObject27 = new gx(30, new gw[] { new gw(8, 122), new gw(4, 123) });
    localObject28 = new gx(28, new gw[] { new gw(22, 45), new gw(3, 46) });
    localObject29 = new gx(30, new gw[] { new gw(8, 23), new gw(26, 24) });
    Object localObject30 = new gx(30, new gw[] { new gw(12, 15), new gw(28, 16) });
    localObject27 = new gv(27, new int[] { 6, 34, 62, 90, 118 }, new gx[] { localObject27, localObject28, localObject29, localObject30 });
    localObject28 = new gx(30, new gw[] { new gw(3, 117), new gw(10, 118) });
    localObject29 = new gx(28, new gw[] { new gw(3, 45), new gw(23, 46) });
    localObject30 = new gx(30, new gw[] { new gw(4, 24), new gw(31, 25) });
    Object localObject31 = new gx(30, new gw[] { new gw(11, 15), new gw(31, 16) });
    localObject28 = new gv(28, new int[] { 6, 26, 50, 74, 98, 122 }, new gx[] { localObject28, localObject29, localObject30, localObject31 });
    localObject29 = new gx(30, new gw[] { new gw(7, 116), new gw(7, 117) });
    localObject30 = new gx(28, new gw[] { new gw(21, 45), new gw(7, 46) });
    localObject31 = new gx(30, new gw[] { new gw(1, 23), new gw(37, 24) });
    Object localObject32 = new gx(30, new gw[] { new gw(19, 15), new gw(26, 16) });
    localObject29 = new gv(29, new int[] { 6, 30, 54, 78, 102, 126 }, new gx[] { localObject29, localObject30, localObject31, localObject32 });
    localObject30 = new gx(30, new gw[] { new gw(5, 115), new gw(10, 116) });
    localObject31 = new gx(28, new gw[] { new gw(19, 47), new gw(10, 48) });
    localObject32 = new gx(30, new gw[] { new gw(15, 24), new gw(25, 25) });
    Object localObject33 = new gx(30, new gw[] { new gw(23, 15), new gw(25, 16) });
    localObject30 = new gv(30, new int[] { 6, 26, 52, 78, 104, 130 }, new gx[] { localObject30, localObject31, localObject32, localObject33 });
    localObject31 = new gx(30, new gw[] { new gw(13, 115), new gw(3, 116) });
    localObject32 = new gx(28, new gw[] { new gw(2, 46), new gw(29, 47) });
    localObject33 = new gx(30, new gw[] { new gw(42, 24), new gw(1, 25) });
    Object localObject34 = new gx(30, new gw[] { new gw(23, 15), new gw(28, 16) });
    localObject31 = new gv(31, new int[] { 6, 30, 56, 82, 108, 134 }, new gx[] { localObject31, localObject32, localObject33, localObject34 });
    localObject32 = new gx(30, new gw[] { new gw(17, 115) });
    localObject33 = new gx(28, new gw[] { new gw(10, 46), new gw(23, 47) });
    localObject34 = new gx(30, new gw[] { new gw(10, 24), new gw(35, 25) });
    Object localObject35 = new gx(30, new gw[] { new gw(19, 15), new gw(35, 16) });
    localObject32 = new gv(32, new int[] { 6, 34, 60, 86, 112, 138 }, new gx[] { localObject32, localObject33, localObject34, localObject35 });
    localObject33 = new gx(30, new gw[] { new gw(17, 115), new gw(1, 116) });
    localObject34 = new gx(28, new gw[] { new gw(14, 46), new gw(21, 47) });
    localObject35 = new gx(30, new gw[] { new gw(29, 24), new gw(19, 25) });
    Object localObject36 = new gx(30, new gw[] { new gw(11, 15), new gw(46, 16) });
    localObject33 = new gv(33, new int[] { 6, 30, 58, 86, 114, 142 }, new gx[] { localObject33, localObject34, localObject35, localObject36 });
    localObject34 = new gx(30, new gw[] { new gw(13, 115), new gw(6, 116) });
    localObject35 = new gx(28, new gw[] { new gw(14, 46), new gw(23, 47) });
    localObject36 = new gx(30, new gw[] { new gw(44, 24), new gw(7, 25) });
    Object localObject37 = new gx(30, new gw[] { new gw(59, 16), new gw(1, 17) });
    localObject34 = new gv(34, new int[] { 6, 34, 62, 90, 118, 146 }, new gx[] { localObject34, localObject35, localObject36, localObject37 });
    localObject35 = new gx(30, new gw[] { new gw(12, 121), new gw(7, 122) });
    localObject36 = new gx(28, new gw[] { new gw(12, 47), new gw(26, 48) });
    localObject37 = new gx(30, new gw[] { new gw(39, 24), new gw(14, 25) });
    Object localObject38 = new gx(30, new gw[] { new gw(22, 15), new gw(41, 16) });
    localObject35 = new gv(35, new int[] { 6, 30, 54, 78, 102, 126, 150 }, new gx[] { localObject35, localObject36, localObject37, localObject38 });
    localObject36 = new gx(30, new gw[] { new gw(6, 121), new gw(14, 122) });
    localObject37 = new gx(28, new gw[] { new gw(6, 47), new gw(34, 48) });
    localObject38 = new gx(30, new gw[] { new gw(46, 24), new gw(10, 25) });
    Object localObject39 = new gx(30, new gw[] { new gw(2, 15), new gw(64, 16) });
    localObject36 = new gv(36, new int[] { 6, 24, 50, 76, 102, 128, 154 }, new gx[] { localObject36, localObject37, localObject38, localObject39 });
    localObject37 = new gx(30, new gw[] { new gw(17, 122), new gw(4, 123) });
    localObject38 = new gx(28, new gw[] { new gw(29, 46), new gw(14, 47) });
    localObject39 = new gx(30, new gw[] { new gw(49, 24), new gw(10, 25) });
    gx localgx1 = new gx(30, new gw[] { new gw(24, 15), new gw(46, 16) });
    localObject37 = new gv(37, new int[] { 6, 28, 54, 80, 106, 132, 158 }, new gx[] { localObject37, localObject38, localObject39, localgx1 });
    localObject38 = new gx(30, new gw[] { new gw(4, 122), new gw(18, 123) });
    localObject39 = new gx(28, new gw[] { new gw(13, 46), new gw(32, 47) });
    localgx1 = new gx(30, new gw[] { new gw(48, 24), new gw(14, 25) });
    gx localgx2 = new gx(30, new gw[] { new gw(42, 15), new gw(32, 16) });
    localObject38 = new gv(38, new int[] { 6, 32, 58, 84, 110, 136, 162 }, new gx[] { localObject38, localObject39, localgx1, localgx2 });
    localObject39 = new gx(30, new gw[] { new gw(20, 117), new gw(4, 118) });
    localgx1 = new gx(28, new gw[] { new gw(40, 47), new gw(7, 48) });
    localgx2 = new gx(30, new gw[] { new gw(43, 24), new gw(22, 25) });
    gx localgx3 = new gx(30, new gw[] { new gw(10, 15), new gw(67, 16) });
    localObject39 = new gv(39, new int[] { 6, 26, 54, 82, 110, 138, 166 }, new gx[] { localObject39, localgx1, localgx2, localgx3 });
    localgx1 = new gx(30, new gw[] { new gw(19, 118), new gw(6, 119) });
    localgx2 = new gx(28, new gw[] { new gw(18, 47), new gw(31, 48) });
    localgx3 = new gx(30, new gw[] { new gw(34, 24), new gw(34, 25) });
    gx localgx4 = new gx(30, new gw[] { new gw(20, 15), new gw(61, 16) });
    return new gv[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, localObject8, localObject9, localObject10, localObject11, localObject12, localObject13, localObject14, localObject15, localObject16, localObject17, localObject18, localObject19, localObject20, localObject21, localObject22, localObject23, localObject24, localObject25, localObject26, localObject27, localObject28, localObject29, localObject30, localObject31, localObject32, localObject33, localObject34, localObject35, localObject36, localObject37, localObject38, localObject39, new gv(40, new int[] { 6, 30, 58, 86, 114, 142, 170 }, new gx[] { localgx1, localgx2, localgx3, localgx4 }) };
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public gx a(ErrorCorrectionLevel paramErrorCorrectionLevel)
  {
    return this.jdField_a_of_type_ArrayOfGx[paramErrorCorrectionLevel.ordinal()];
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
 * Qualified Name:     gv
 * JD-Core Version:    0.7.0.1
 */