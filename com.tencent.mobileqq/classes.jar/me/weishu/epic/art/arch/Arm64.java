package me.weishu.epic.art.arch;

import java.nio.ByteOrder;

public class Arm64
  extends ShellCode
{
  public byte[] createBridgeJump(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    byte[] arrayOfByte = new byte[96];
    byte[] tmp8_6 = arrayOfByte;
    tmp8_6[0] = 31;
    byte[] tmp13_8 = tmp8_6;
    tmp13_8[1] = 32;
    byte[] tmp18_13 = tmp13_8;
    tmp18_13[2] = 3;
    byte[] tmp23_18 = tmp18_13;
    tmp23_18[3] = -43;
    byte[] tmp28_23 = tmp23_18;
    tmp28_23[4] = 105;
    byte[] tmp33_28 = tmp28_23;
    tmp33_28[5] = 2;
    byte[] tmp38_33 = tmp33_28;
    tmp38_33[6] = 0;
    byte[] tmp44_38 = tmp38_33;
    tmp44_38[7] = 88;
    byte[] tmp50_44 = tmp44_38;
    tmp50_44[8] = 31;
    byte[] tmp56_50 = tmp50_44;
    tmp56_50[9] = 0;
    byte[] tmp62_56 = tmp56_50;
    tmp62_56[10] = 9;
    byte[] tmp68_62 = tmp62_56;
    tmp68_62[11] = -21;
    byte[] tmp74_68 = tmp68_62;
    tmp74_68[12] = -95;
    byte[] tmp80_74 = tmp74_68;
    tmp80_74[13] = 2;
    byte[] tmp86_80 = tmp80_74;
    tmp86_80[14] = 0;
    byte[] tmp92_86 = tmp86_80;
    tmp92_86[15] = 84;
    byte[] tmp98_92 = tmp92_86;
    tmp98_92[16] = -128;
    byte[] tmp104_98 = tmp98_92;
    tmp104_98[17] = 1;
    byte[] tmp110_104 = tmp104_98;
    tmp110_104[18] = 0;
    byte[] tmp116_110 = tmp110_104;
    tmp116_110[19] = 88;
    byte[] tmp122_116 = tmp116_110;
    tmp122_116[20] = 41;
    byte[] tmp128_122 = tmp122_116;
    tmp128_122[21] = 2;
    byte[] tmp134_128 = tmp128_122;
    tmp134_128[22] = 0;
    byte[] tmp140_134 = tmp134_128;
    tmp140_134[23] = 88;
    byte[] tmp146_140 = tmp140_134;
    tmp146_140[24] = -22;
    byte[] tmp152_146 = tmp146_140;
    tmp152_146[25] = 3;
    byte[] tmp158_152 = tmp152_146;
    tmp158_152[26] = 0;
    byte[] tmp164_158 = tmp158_152;
    tmp164_158[27] = -111;
    byte[] tmp170_164 = tmp164_158;
    tmp170_164[28] = 42;
    byte[] tmp176_170 = tmp170_164;
    tmp176_170[29] = 1;
    byte[] tmp182_176 = tmp176_170;
    tmp182_176[30] = 0;
    byte[] tmp188_182 = tmp182_176;
    tmp188_182[31] = -7;
    byte[] tmp194_188 = tmp188_182;
    tmp194_188[32] = 34;
    byte[] tmp200_194 = tmp194_188;
    tmp200_194[33] = 5;
    byte[] tmp206_200 = tmp200_194;
    tmp206_200[34] = 0;
    byte[] tmp212_206 = tmp206_200;
    tmp212_206[35] = -7;
    byte[] tmp218_212 = tmp212_206;
    tmp218_212[36] = 35;
    byte[] tmp224_218 = tmp218_212;
    tmp224_218[37] = 9;
    byte[] tmp230_224 = tmp224_218;
    tmp230_224[38] = 0;
    byte[] tmp236_230 = tmp230_224;
    tmp236_230[39] = -7;
    byte[] tmp242_236 = tmp236_230;
    tmp242_236[40] = -29;
    byte[] tmp248_242 = tmp242_236;
    tmp248_242[41] = 3;
    byte[] tmp254_248 = tmp248_242;
    tmp254_248[42] = 9;
    byte[] tmp260_254 = tmp254_248;
    tmp260_254[43] = -86;
    byte[] tmp266_260 = tmp260_254;
    tmp266_260[44] = 34;
    byte[] tmp272_266 = tmp266_260;
    tmp272_266[45] = 1;
    byte[] tmp278_272 = tmp272_266;
    tmp278_272[46] = 0;
    byte[] tmp284_278 = tmp278_272;
    tmp284_278[47] = 88;
    byte[] tmp290_284 = tmp284_278;
    tmp290_284[48] = 34;
    byte[] tmp296_290 = tmp290_284;
    tmp296_290[49] = 13;
    byte[] tmp302_296 = tmp296_290;
    tmp302_296[50] = 0;
    byte[] tmp308_302 = tmp302_296;
    tmp308_302[51] = -7;
    byte[] tmp314_308 = tmp308_302;
    tmp314_308[52] = -30;
    byte[] tmp320_314 = tmp314_308;
    tmp320_314[53] = 3;
    byte[] tmp326_320 = tmp320_314;
    tmp326_320[54] = 19;
    byte[] tmp332_326 = tmp326_320;
    tmp332_326[55] = -86;
    byte[] tmp338_332 = tmp332_326;
    tmp338_332[56] = -119;
    byte[] tmp344_338 = tmp338_332;
    tmp344_338[57] = 0;
    byte[] tmp350_344 = tmp344_338;
    tmp350_344[58] = 0;
    byte[] tmp356_350 = tmp350_344;
    tmp356_350[59] = 88;
    byte[] tmp362_356 = tmp356_350;
    tmp362_356[60] = 32;
    byte[] tmp368_362 = tmp362_356;
    tmp368_362[61] = 1;
    byte[] tmp374_368 = tmp368_362;
    tmp374_368[62] = 31;
    byte[] tmp380_374 = tmp374_368;
    tmp380_374[63] = -42;
    byte[] tmp386_380 = tmp380_374;
    tmp386_380[64] = 0;
    byte[] tmp392_386 = tmp386_380;
    tmp392_386[65] = 0;
    byte[] tmp398_392 = tmp392_386;
    tmp398_392[66] = 0;
    byte[] tmp404_398 = tmp398_392;
    tmp404_398[67] = 0;
    byte[] tmp410_404 = tmp404_398;
    tmp410_404[68] = 0;
    byte[] tmp416_410 = tmp410_404;
    tmp416_410[69] = 0;
    byte[] tmp422_416 = tmp416_410;
    tmp422_416[70] = 0;
    byte[] tmp428_422 = tmp422_416;
    tmp428_422[71] = 0;
    byte[] tmp434_428 = tmp428_422;
    tmp434_428[72] = 0;
    byte[] tmp440_434 = tmp434_428;
    tmp440_434[73] = 0;
    byte[] tmp446_440 = tmp440_434;
    tmp446_440[74] = 0;
    byte[] tmp452_446 = tmp446_440;
    tmp452_446[75] = 0;
    byte[] tmp458_452 = tmp452_446;
    tmp458_452[76] = 0;
    byte[] tmp464_458 = tmp458_452;
    tmp464_458[77] = 0;
    byte[] tmp470_464 = tmp464_458;
    tmp470_464[78] = 0;
    byte[] tmp476_470 = tmp470_464;
    tmp476_470[79] = 0;
    byte[] tmp482_476 = tmp476_470;
    tmp482_476[80] = 0;
    byte[] tmp488_482 = tmp482_476;
    tmp488_482[81] = 0;
    byte[] tmp494_488 = tmp488_482;
    tmp494_488[82] = 0;
    byte[] tmp500_494 = tmp494_488;
    tmp500_494[83] = 0;
    byte[] tmp506_500 = tmp500_494;
    tmp506_500[84] = 0;
    byte[] tmp512_506 = tmp506_500;
    tmp512_506[85] = 0;
    byte[] tmp518_512 = tmp512_506;
    tmp518_512[86] = 0;
    byte[] tmp524_518 = tmp518_512;
    tmp524_518[87] = 0;
    byte[] tmp530_524 = tmp524_518;
    tmp530_524[88] = 0;
    byte[] tmp536_530 = tmp530_524;
    tmp536_530[89] = 0;
    byte[] tmp542_536 = tmp536_530;
    tmp542_536[90] = 0;
    byte[] tmp548_542 = tmp542_536;
    tmp548_542[91] = 0;
    byte[] tmp554_548 = tmp548_542;
    tmp554_548[92] = 0;
    byte[] tmp560_554 = tmp554_548;
    tmp560_554[93] = 0;
    byte[] tmp566_560 = tmp560_554;
    tmp566_560[94] = 0;
    byte[] tmp572_566 = tmp566_560;
    tmp572_566[95] = 0;
    tmp572_566;
    writeLong(paramLong1, ByteOrder.LITTLE_ENDIAN, tmp23_18, tmp23_18.length - 32);
    writeLong(paramLong2, ByteOrder.LITTLE_ENDIAN, tmp23_18, tmp23_18.length - 24);
    writeLong(paramLong3, ByteOrder.LITTLE_ENDIAN, tmp23_18, tmp23_18.length - 16);
    writeLong(tmp13_8, ByteOrder.LITTLE_ENDIAN, tmp23_18, tmp23_18.length - 8);
    return tmp23_18;
  }
  
  public byte[] createDirectJump(long paramLong)
  {
    byte[] arrayOfByte = new byte[16];
    byte[] tmp6_5 = arrayOfByte;
    tmp6_5[0] = 80;
    byte[] tmp11_6 = tmp6_5;
    tmp11_6[1] = 0;
    byte[] tmp16_11 = tmp11_6;
    tmp16_11[2] = 0;
    byte[] tmp21_16 = tmp16_11;
    tmp21_16[3] = 88;
    byte[] tmp26_21 = tmp21_16;
    tmp26_21[4] = 0;
    byte[] tmp31_26 = tmp26_21;
    tmp31_26[5] = 2;
    byte[] tmp36_31 = tmp31_26;
    tmp36_31[6] = 31;
    byte[] tmp42_36 = tmp36_31;
    tmp42_36[7] = -42;
    byte[] tmp48_42 = tmp42_36;
    tmp48_42[8] = 0;
    byte[] tmp54_48 = tmp48_42;
    tmp54_48[9] = 0;
    byte[] tmp60_54 = tmp54_48;
    tmp60_54[10] = 0;
    byte[] tmp66_60 = tmp60_54;
    tmp66_60[11] = 0;
    byte[] tmp72_66 = tmp66_60;
    tmp72_66[12] = 0;
    byte[] tmp78_72 = tmp72_66;
    tmp78_72[13] = 0;
    byte[] tmp84_78 = tmp78_72;
    tmp84_78[14] = 0;
    byte[] tmp90_84 = tmp84_78;
    tmp90_84[15] = 0;
    tmp90_84;
    writeLong(paramLong, ByteOrder.LITTLE_ENDIAN, tmp6_5, tmp6_5.length - 8);
    return tmp6_5;
  }
  
  public String getName()
  {
    return "64-bit ARM";
  }
  
  public int sizeOfBridgeJump()
  {
    return 96;
  }
  
  public int sizeOfDirectJump()
  {
    return 16;
  }
  
  public long toMem(long paramLong)
  {
    return paramLong;
  }
  
  public long toPC(long paramLong)
  {
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.weishu.epic.art.arch.Arm64
 * JD-Core Version:    0.7.0.1
 */