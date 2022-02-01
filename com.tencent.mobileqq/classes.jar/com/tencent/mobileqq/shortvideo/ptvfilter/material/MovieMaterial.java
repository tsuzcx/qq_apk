package com.tencent.mobileqq.shortvideo.ptvfilter.material;

public class MovieMaterial
{
  public String atmosphereAudioPath;
  public String atmosphereName;
  public String atmosphereVideoPath;
  public String doodleAudioPath;
  public String doodleName;
  public String doodleVideoPath;
  public boolean hasAtmosphere;
  public String hintImagePath;
  public String hintsContent;
  public String hintsImageName;
  public boolean isTouchable;
  public boolean loopAtmosphere;
  public boolean loopDoodle;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MovieInfo{isTouchable='");
    localStringBuilder.append(this.isTouchable);
    localStringBuilder.append('\'');
    localStringBuilder.append(", hasAtmosphere='");
    localStringBuilder.append(this.hasAtmosphere);
    localStringBuilder.append('\'');
    localStringBuilder.append(", loopAtmosphere='");
    localStringBuilder.append(this.loopAtmosphere);
    localStringBuilder.append('\'');
    localStringBuilder.append(", loopDoodle='");
    localStringBuilder.append(this.loopDoodle);
    localStringBuilder.append('\'');
    localStringBuilder.append(", doodleName='");
    localStringBuilder.append(this.doodleName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", atmosphereName='");
    localStringBuilder.append(this.atmosphereName);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ptvfilter.material.MovieMaterial
 * JD-Core Version:    0.7.0.1
 */